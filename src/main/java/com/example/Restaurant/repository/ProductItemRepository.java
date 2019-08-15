package com.example.Restaurant.repository;

import com.example.Restaurant.domain.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Integer> {
}
