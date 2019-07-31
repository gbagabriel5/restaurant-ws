package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.SaleService;
import com.example.Restaurant.domain.Sale;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl extends GenericServiceImpl<Sale, Integer> implements SaleService {
    @Override
    public void trim(Sale entity) {
    }
}