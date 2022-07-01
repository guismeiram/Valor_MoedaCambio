package com.example.jpql_cs.repository;

import com.example.jpql_cs.model.Favorita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritosRepository extends JpaRepository<Favorita, Long> {

}
