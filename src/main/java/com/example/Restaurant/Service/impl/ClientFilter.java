package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.Filter;
import com.example.Restaurant.Service.GenericFilter;
import com.example.Restaurant.domain.Client;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class ClientFilter extends Filter<Client> implements GenericFilter {

    public ClientFilter(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void initialize() {
        super.initialize(Client.class);
    }
}
