package br.com.ulbra.aula27.dto.livros;

public class LivroRequestDTO {
    public String titulo;
    public String isbn;
    public Long autorId;

    // ID do autor responsável


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
}
