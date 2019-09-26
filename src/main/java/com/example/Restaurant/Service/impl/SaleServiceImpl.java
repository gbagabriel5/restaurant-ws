package com.example.Restaurant.Service.impl;

import com.example.Restaurant.Service.SaleService;
import com.example.Restaurant.domain.ItemSale;
import com.example.Restaurant.domain.Sale;
import com.example.Restaurant.dto.SaleDto;
import com.example.Restaurant.repository.ItemSaleRepository;
import com.example.Restaurant.repository.ProductRepository;
import com.example.Restaurant.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl extends GenericServiceImpl<Sale, Integer> implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ItemSaleRepository itemSaleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void trim(Sale entity) {
    }

    private void saveItens(Sale entity, Sale salesave) {
        for (ItemSale itemSale : entity.getItemSale()) {

            itemSale.setSale(salesave);
            itemSale.setProduct(itemSale.getProduct());
            itemSale.setQuantity(itemSale.getQuantity());

            int qt = itemSale.getProduct().getQuantity();
            int itqt = itemSale.getQuantity();
            int result = qt - itqt;
            itemSale.getProduct().setQuantity(result);

            productRepository.save(itemSale.getProduct());
            itemSaleRepository.save(itemSale);
        }
    }

    @Override
    public Sale add(Sale entity) {
        try {
            Sale salesave = super.add(entity);
            saveItens(entity, salesave);
            entity = salesave;
        } catch (Exception ex) {
            new Exception("Não foi possivel salvar o item" + ex);
        }
        return entity;
    }

    @Override
    public List<SaleDto> findByTable(Integer tcod) {
        return null;
    }
}