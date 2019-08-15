package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.Filter;
import com.example.Restaurant.Service.GenericFilter;
import com.example.Restaurant.domain.Product;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class ProductFilter extends Filter<Product> implements GenericFilter {

    public ProductFilter(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void initialize() {
        super.initialize(Product.class);
    }
}
