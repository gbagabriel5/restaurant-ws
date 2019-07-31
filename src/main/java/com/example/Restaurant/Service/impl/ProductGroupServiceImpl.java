package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.ProductGroupService;
import com.example.Restaurant.domain.ProductGroup;
import org.springframework.stereotype.Service;

@Service
public class ProductGroupServiceImpl extends GenericServiceImpl<ProductGroup, Integer> implements ProductGroupService {
    @Override
    public void trim(ProductGroup entity) {
    }
}