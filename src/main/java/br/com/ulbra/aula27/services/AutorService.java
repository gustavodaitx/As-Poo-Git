package br.com.ulbra.aula27.services;

import br.com.ulbra.aula27.dto.autor.AutorRequestDTO;
import br.com.ulbra.aula27.dto.autor.AutorResponseDTO;
import br.com.ulbra.aula27.dto.livros.LivroResponseDTO;
import br.com.ulbra.aula27.entities.Autor;
import br.com.ulbra.aula27.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private LivroService livroService;

    /**
     * Cria um autor
     */
    public Autor create(AutorRequestDTO dto) {
        Autor autor = new Autor();
        autor.setNome(dto.nome);
        autor.setEmail(dto.email);
        return repository.save(autor);
    }

    /**
     * Lista todos os autores convertidos em DTO
     */
    public List<AutorResponseDTO.AutorListDTO> list() {
        return repository.findAll().stream()
                .map(autor ->
                        new AutorResponseDTO.AutorListDTO(
                                autor.getId(),
                                autor.getNome()
                                )).toList();


    }

    // ✔ Buscar por ID
    public AutorResponseDTO findById(Long id) {
        Autor autor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado!"));

        return toResponse(autor);
    }

    // ✔ Atualizar
    public AutorResponseDTO update(Long id, AutorRequestDTO dto) {
        Autor autor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado!"));

        autor.setNome(dto.nome);
        autor.setEmail(dto.email);

        repository.save(autor);
        return toResponse(autor);
    }

    // ✔ Remover
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // 🔄 Conversão Entity → DTO
    private AutorResponseDTO toResponse(Autor autor) {
        return new AutorResponseDTO(
                autor.getId(),
                autor.getNome(),
                autor.getEmail(),
                autor.getLivros() != null ?
                        autor.getLivros().stream()
                                .map(l -> new LivroResponseDTO(
                                        l.getId(),
                                        l.getTitle(),
                                        l.getIsbn(),
                                        autor.getId(),
                                        autor.setNome()
                                )).toList() : List.of()
        );
    }
}
