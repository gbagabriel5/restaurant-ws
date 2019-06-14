package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.Filter;
import com.example.Restaurant.Service.GenericFilter;
import com.example.Restaurant.model.Cliente;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class ClienteFilter extends Filter<Cliente> implements GenericFilter {
    public ClienteFilter(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void initialize() {
        super.initialize(Cliente.class);
    }
}
