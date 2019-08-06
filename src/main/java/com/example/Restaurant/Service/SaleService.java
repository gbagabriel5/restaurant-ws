package com.example.Restaurant.Service;

import com.example.Restaurant.domain.Sale;
import com.example.Restaurant.dto.SaleDto;

public interface SaleService extends GenericService<Sale, Integer> {
    SaleDto startSale(SaleDto saleDto);
}