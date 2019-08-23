package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.Sale;
import com.example.Restaurant.dto.SaleDto;

public class SaleMapper implements GenericMapper<Sale, SaleDto> {
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
        return entity;
    }
}