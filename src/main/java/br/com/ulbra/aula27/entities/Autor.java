package br.com.ulbra.aula27.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros = new ArrayList<>();

    public Autor(String nome, String email) {}

    public Autor(Long id, String nome, String email, String password, List<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.email = email;

        this.livros = livros;
    }

    public Autor() {

    }

    public List<Livro> getPosts() {
        return livros;
    }

    public void setPosts(List<Livro> livros) {
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

    public void setNome(String name) {
        this.nome = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void addLivros(Livro livros) {
        livros.add(livros);
        livros.setAutor(this);
    }


    public void removeLivros(Livro livros) {
        livros.remove(livros);
        livros.setAutor(null);
    }

    public List<Livro> getLivros() {
        return List.of();
    }


    public String setNome() {
        return nome;
    }
}