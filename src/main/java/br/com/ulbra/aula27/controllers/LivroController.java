package br.com.ulbra.aula27.controllers;

import br.com.ulbra.aula27.dto.autor.AutorResponseDTO;
import br.com.ulbra.aula27.dto.livros.AutorRequestDTO;
import br.com.ulbra.aula27.dto.livros.LivroRequestDTO;
import br.com.ulbra.aula27.dto.livros.LivroResponseDTO;
import br.com.ulbra.aula27.services.AutorService;
import br.com.ulbra.aula27.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")

public class LivroController {

    @Autowired
    private LivroService service;
    @Autowired
    private AutorService autorService;
    @Autowired
    private LivroService livroService;

    @PostMapping
    public LivroResponseDTO create(@RequestBody LivroRequestDTO dto) {
        return new LivroResponseDTO(
                service.create(dto).getId(),
                dto.titulo,
                dto.isbn,
                dto.autorId
        );
    }

    // ✔ Buscar todos os livros
    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> getAll() {

        // Busca todos os livros no Service
        List<LivroResponseDTO> livros = livroService.listAll();

        // Retorna status 200 com a lista no corpo da resposta
        return ResponseEntity.ok(livros);
    }




    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> getLivro(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> updateLivro(
            @PathVariable Long id,
            @RequestBody LivroRequestDTO dto) {
        return ResponseEntity.ok(livroService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
