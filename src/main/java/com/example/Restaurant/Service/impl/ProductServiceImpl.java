package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.ProductService;
import com.example.Restaurant.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, Integer> implements ProductService {
    @Override
    public void trim(Product entity) {
    }
}