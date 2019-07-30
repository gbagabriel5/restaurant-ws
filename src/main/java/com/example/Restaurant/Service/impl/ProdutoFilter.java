package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.Filter;
import com.example.Restaurant.Service.GenericFilter;
import com.example.Restaurant.model.Produto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class ProdutoFilter extends Filter<Produto> implements GenericFilter {
    public ProdutoFilter(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void initialize() {
        super.initialize(Produto.class);
    }
}
