package br.com.ulbra.aula27.repositories;
import br.com.ulbra.aula27.entities.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivrosRepository extends JpaRepository<Livros, Long> {
    // Busca todos os livros de um autor
    List<Livros> findByAutorId(Long authorId);
}