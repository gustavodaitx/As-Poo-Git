package br.com.ulbra.aula27.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "autor")
    private List<Livros> livros = new ArrayList<>();

    public Autor(String nome, String email) {}

    public Autor(Long id, String name, String email, String password, List<Livros> livros) {
        this.id = id;
        this.name = name;
        this.email = email;

        this.livros = livros;
    }

    public Autor() {

    }

    public List<Livros> getPosts() {
        return livros;
    }

    public void setPosts(List<Livros> livros) {
        this.livros = livros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void addLivros(Livros livros) {
        livros.add(livros);
        livros.setAutor(this);
    }


    public void removeLivros(Livros livros) {
        livros.remove(livros);
        livros.setAutor(null);
    }

    public List<Livros> getLivros() {
        return List.of();
    }
}