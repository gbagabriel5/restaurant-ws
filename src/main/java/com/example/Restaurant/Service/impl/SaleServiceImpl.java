package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.SaleService;
import com.example.Restaurant.domain.Sale;
import com.example.Restaurant.dto.SaleDto;
import com.example.Restaurant.mapper.SaleMapper;
import com.example.Restaurant.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl extends GenericServiceImpl<Sale, Integer> implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    private SaleMapper saleMapper = new SaleMapper();

    @Override
    public void trim(Sale entity) {
    }

    @Override
    public SaleDto startSale(SaleDto saleDto) {
        Sale sale;
        sale = saleRepository.save(saleMapper.convertToEntity(saleDto));
        return saleMapper.convertToDTO(sale);
    }
}