package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.Filter;
import com.example.Restaurant.Service.GenericFilter;
import com.example.Restaurant.domain.Item;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class ItemFilter extends Filter<Item> implements GenericFilter {

    public ItemFilter(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void initialize() {
        super.initialize(Item.class);
    }
}
