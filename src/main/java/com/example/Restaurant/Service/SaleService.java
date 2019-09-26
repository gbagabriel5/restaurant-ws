package com.example.Restaurant.Service;

import com.example.Restaurant.domain.Sale;
import com.example.Restaurant.dto.SaleDto;
import java.util.List;

public interface SaleService extends GenericService<Sale, Integer> {
    List<SaleDto> findByTable(Integer tcod);
}