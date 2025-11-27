package br.com.ulbra.aula27.services;

import br.com.ulbra.aula27.dto.livros.LivroRequestDTO;
import br.com.ulbra.aula27.dto.livros.LivroResponseDTO;
import br.com.ulbra.aula27.entities.Autor;
import br.com.ulbra.aula27.entities.Livro;
import br.com.ulbra.aula27.repositories.AutorRepository;
import br.com.ulbra.aula27.repositories.LivrosRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class LivroService {

    private final LivrosRepository repository;
    private final AutorRepository autorRepository;

    public LivroService(LivrosRepository repository, AutorRepository autorRepository) {
        this.repository = repository;
        this.autorRepository = autorRepository;
    }

    // ✔ Criar livro
    public LivroResponseDTO create(LivroRequestDTO dto) {
        Autor autor = autorRepository.findById(dto.autorId)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado!"));

        Livro livro = new Livro();
        livro.setTitle(dto.titulo);
        livro.setIsbn(dto.isbn);
        livro.setAutor(autor);

        Livro saved = repository.save(livro);
        return toResponse(saved);
    }

    // ✔ Listar todos
    public List<LivroResponseDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // ✔ Buscar por ID
    public LivroResponseDTO findById(Long id) {
        Livro livro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado!"));

        return toResponse(livro);
    }

    // ✔ Atualizar
    public LivroResponseDTO update(Long id, LivroRequestDTO dto) {
        Livro livro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado!"));

        Autor autor = autorRepository.findById(dto.autorId)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado!"));

        livro.setTitle(dto.titulo);
        livro.setIsbn(dto.isbn);
        livro.setAutor(autor);

        repository.save(livro);
        return toResponse(livro);
    }

    // ✔ Remover
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // 🔄 Entity → DTO
    private LivroResponseDTO toResponse(Livro livro) {
        return new LivroResponseDTO(
                livro.getId(),
                livro.getTitle(),
                livro.getIsbn(),
                livro.getAutor() != null ? livro.getAutor().getId() : null,
                livro.getAutor() != null ? livro.getAutor().getNome() : "SEM AUTOR"
        );
    }
}

