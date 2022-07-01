package com.example.jpql_cs.repository;

import com.example.jpql_cs.model.Noticias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<Noticias, Long> {
}
