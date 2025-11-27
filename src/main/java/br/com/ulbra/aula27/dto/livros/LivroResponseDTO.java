package br.com.ulbra.aula27.dto.livros;

public class LivroResponseDTO {
    public Long id;
    public String titulo;
    public String isbn;
    public Long autorId;
    String autorNome;

    public LivroResponseDTO(Long id, String titulo, String isbn, Long autorId,  String autorNome) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autorId = autorId;
        this.autorNome = autorNome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public String getAutorNome() {
        return autorNome;
    }

    public void setAutorNome(String autorNome) {
        this.autorNome = autorNome;
    }
}

