package br.com.ulbra.aula27.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")

public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Livro(String titulo, String isbn, Autor autor) {}

    public Livro(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public Livro() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void add(Livro livros) {
    }

    public void remove(Livro livros) {
    }
}