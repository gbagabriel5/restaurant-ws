package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.TablesService;
import com.example.Restaurant.domain.Tables;
import com.example.Restaurant.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TablesServiceImpl extends GenericServiceImpl<Tables, Integer> implements TablesService {
    private boolean bo;

    @Autowired
    private TablesRepository tablesRepository;

    @Override
    public void trim(Tables entity) {
    }

    @Override
    public boolean findBusyTable(Integer id) {
        Tables table = get(id);
        if (table.getStatus().equals("Disponível"))
            bo=true;
        else
            bo=false;
        return bo;
    }
}