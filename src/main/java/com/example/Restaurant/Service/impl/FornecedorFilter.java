package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.Filter;
import com.example.Restaurant.Service.GenericFilter;
import com.example.Restaurant.model.Fornecedor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;

@Service
public class FornecedorFilter extends Filter<Fornecedor> implements GenericFilter {
    public FornecedorFilter(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void initialize() {
        super.initialize(Fornecedor.class);
    }
}
