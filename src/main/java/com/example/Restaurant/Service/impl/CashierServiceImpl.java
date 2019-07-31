package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.CashierService;
import com.example.Restaurant.domain.Cashier;
import org.springframework.stereotype.Service;

@Service
public class CashierServiceImpl extends GenericServiceImpl<Cashier, Integer> implements CashierService {
    @Override
    public void trim(Cashier entity) {
    }
}