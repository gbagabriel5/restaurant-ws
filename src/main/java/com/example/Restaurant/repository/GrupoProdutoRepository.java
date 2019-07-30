package com.example.Restaurant.repository;

import com.example.Restaurant.model.GrupoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrupoProdutoRepository extends JpaRepository<GrupoProduto, Integer> {
    @Query("SELECT gp FROM GrupoProduto gp WHERE gp.cod = :pId")
    Optional<GrupoProduto> findById(@Param("pId") Integer id);
}
