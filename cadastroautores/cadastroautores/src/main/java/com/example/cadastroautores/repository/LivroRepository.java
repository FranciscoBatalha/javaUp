package com.example.cadastroautores.repository;
import com.example.cadastroautores.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}

