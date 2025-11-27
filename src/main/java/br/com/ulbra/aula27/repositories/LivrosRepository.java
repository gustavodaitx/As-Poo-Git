package br.com.ulbra.aula27.repositories;
import br.com.ulbra.aula27.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivrosRepository extends JpaRepository<Livro, Long> {
    // Busca todos os livros de um autor
    List<Livro> findByAutorId(Long authorId);
}