package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.Filter;
import com.example.Restaurant.Service.GenericFilter;
import com.example.Restaurant.model.GrupoProduto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class GrupoProdutoFilter extends Filter<GrupoProduto> implements GenericFilter {
    public GrupoProdutoFilter(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void initialize() {
        super.initialize(GrupoProduto.class);
    }
}
