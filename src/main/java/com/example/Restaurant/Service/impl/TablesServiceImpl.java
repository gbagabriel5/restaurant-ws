package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.TablesService;
import com.example.Restaurant.domain.Tables;
import org.springframework.stereotype.Service;

@Service
public class TablesServiceImpl extends GenericServiceImpl<Tables, Integer> implements TablesService {
    @Override
    public void trim(Tables entity) {
    }
}