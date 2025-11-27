package br.com.ulbra.aula27.controllers;

import br.com.ulbra.aula27.dto.autor.AutorResponseDTO;
import br.com.ulbra.aula27.dto.livros.AutorRequestDTO;
import br.com.ulbra.aula27.repositories.AutorRepository;
import br.com.ulbra.aula27.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")

public class AutorController {

    @Autowired
    private AutorService service;
    @Autowired
    private AutorService autorService;

    @PostMapping
    public AutorResponseDTO create(@RequestBody AutorRequestDTO dto) {
        return new AutorResponseDTO(
                service.create(dto).getId(),
                dto.nome,
                dto.email,
                List.of()
        );
    }

    @GetMapping
    public List<AutorResponseDTO> list() {
        return service.list();
    }

    // ✔ Buscar Autor por ID
    @GetMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> getAutor(@PathVariable Long id) {

        // Chama o service para buscar o autor por ID
        AutorResponseDTO dto = autorService.findById(id);

        // Retorna 200 OK com o DTO do autor
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> updateAutor(
            @PathVariable Long id,
            @RequestBody AutorRequestDTO dto) {

        AutorResponseDTO autorAtualizado = autorService.update(id, dto);
        return ResponseEntity.ok(autorAtualizado);
    }

}
