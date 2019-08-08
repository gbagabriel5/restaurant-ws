package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.ItemCategoryService;
import com.example.Restaurant.domain.ItemCategory;
import org.springframework.stereotype.Service;

@Service
public class ItemCategoryServiceImpl extends GenericServiceImpl<ItemCategory, Integer> implements ItemCategoryService {
    @Override
    public void trim(ItemCategory entity) {
    }
}