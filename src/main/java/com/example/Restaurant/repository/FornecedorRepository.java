package com.example.Restaurant.repository;

import com.example.Restaurant.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
    @Query("SELECT f FROM Fornecedor f WHERE f.cod = :pId")
    Optional<Fornecedor> findById(@Param("pId") Integer id);
}
