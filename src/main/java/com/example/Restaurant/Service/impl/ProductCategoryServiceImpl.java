package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.ProductCategoryService;
import com.example.Restaurant.domain.ProductCategory;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl extends GenericServiceImpl<ProductCategory, Integer> implements ProductCategoryService {
    @Override
    public void trim(ProductCategory entity) {
    }
}