package com.example.Restaurant.repository;

import com.example.Restaurant.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    @Query("SELECT c FROM Cliente c WHERE c.clicod = :pId")
    Optional<Cliente> findById(@Param("pId") Integer id);
}
