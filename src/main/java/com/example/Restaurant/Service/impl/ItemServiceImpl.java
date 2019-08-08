package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.ItemService;
import com.example.Restaurant.domain.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends GenericServiceImpl<Item,Integer> implements ItemService {
    @Override
    public void trim(Item entity) {
    }
}