package br.com.ulbra.aula27.dto.autor;
import br.com.ulbra.aula27.dto.livros.LivroResponseDTO;

import java.util.List;

/**
 * DTO enviado ao cliente sem expor a entidade JPA
 */
public class AutorResponseDTO {
    public Long id;
    public String nome;
    public String email;
    public List<LivroResponseDTO> livros;

    public AutorResponseDTO(Long id, String nome, String email, List<LivroResponseDTO> livros) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.livros = livros;
    }

    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<LivroResponseDTO> getLivros() {
        return livros;
    }

    public void setLivros(List<LivroResponseDTO> livros) {
        this.livros = livros;
    }
}
