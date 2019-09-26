package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.ItemSale;
import com.example.Restaurant.domain.Sale;
import com.example.Restaurant.dto.*;
import com.example.Restaurant.dto.CustomDto.SaleCustomDto;
import org.modelmapper.ModelMapper;

public class SaleMapper implements GenericMapper<Sale, SaleDto> {
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public SaleDto convertToDTO(Sale entity) {
        SaleDto dto = new SaleDto();
        dto.setId(entity.getId());
        if (entity.getCashier() != null) {
            dto.setCashierDto(new CashierMapper().convertToDTO(entity.getCashier()));
        }
        if (entity.getTables() != null) {
            dto.setTablesDto(new TableMapper().convertToDTO(entity.getTables()));
        }
        dto.setDate(entity.getDate());
        dto.setHour(entity.getHour());
        dto.setTotal(entity.getTotal());
        dto.setPayment(entity.getPayment());
        dto.setMoneyRecievid(entity.getMoneyRecievid());
        dto.setChange(entity.getChange());
        dto.setStatus(entity.getStatus());
        dto.setOut(entity.getOut());
        dto.setDescription(entity.getDescription());

        if(!entity.getItemSale().isEmpty()){
            entity.getItemSale().forEach(itemSale -> {
                ItemSaleDto itemSaleDto = new ItemSaleDto();

                itemSaleDto.setId(itemSale.getId());

                SaleDto sdto = new SaleDto();
                sdto.setId(itemSale.getSale().getId());
                itemSaleDto.setSaleDto(modelMapper.map(itemSale.getSale(), SaleDto.class));

                ProductDto productDto = new ProductDto();
                productDto.setId(itemSale.getProduct().getId());
                itemSaleDto.setProductDto(modelMapper.map(itemSale.getProduct(), ProductDto.class));

                itemSaleDto.setQuantity(itemSale.getQuantity());
                itemSaleDto.setObs(itemSale.getObs());
                dto.getItemSaleDtos().add(itemSaleDto);
            });
        }
        return dto;
    }

    @Override
    public Sale convertToEntity(SaleDto dto) {
        Sale entity = new Sale();
        entity.setId(entity.getId());
        if (dto.getCashierDto() != null) {
            entity.setCashier(new CashierMapper().convertToEntity(dto.getCashierDto()));
        }
        if (dto.getTablesDto() != null) {
            entity.setTables(new TableMapper().convertToEntity(dto.getTablesDto()));
        }
        entity.setDate(dto.getDate());
        entity.setHour(dto.getHour());
        entity.setTotal(dto.getTotal());
        entity.setPayment(dto.getPayment());
        entity.setMoneyRecievid(dto.getMoneyRecievid());
        entity.setChange(dto.getChange());
        entity.setStatus(dto.getStatus());
        entity.setOut(dto.getOut());
        entity.setDescription(dto.getDescription());

        if(!dto.getItemSaleDtos().isEmpty()){
            dto.getItemSaleDtos().forEach(itemDto ->
                entity.getItemSale().add(converteItemSaleToEntity(itemDto))
            );
        }
        return entity;
    }

    private ItemSale converteItemSaleToEntity(ItemSaleDto dto) {
        ItemSale entity = new ItemSale();
        entity.setId(dto.getId());
        entity.setSale(modelMapper.map(dto.getSaleDto(), Sale.class));
        if (dto.getProductDto() != null) {
            entity.setProduct(new ProductMapper().convertToEntity(dto.getProductDto()));
        }
        entity.setQuantity(dto.getQuantity());
        entity.setObs(dto.getObs());
        return entity;

    }
}