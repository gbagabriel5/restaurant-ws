package com.example.Restaurant.repository;

import com.example.Restaurant.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
    @Query("SELECT t FROM Sale t WHERE t.tables = :tcod")
    List<Sale> findByTable(@Param("tcod") Integer tcod);
}