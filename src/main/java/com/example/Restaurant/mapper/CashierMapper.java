package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.Cashier;
import com.example.Restaurant.dto.CashierDto;

public class CashierMapper implements GenericMapper<Cashier, CashierDto> {

    @Override
    public CashierDto convertToDTO(Cashier entity) {
        CashierDto dto = new CashierDto();
        dto.setId(entity.getId());
        dto.setOpenDate(entity.getOpenDate());
        dto.setClosureDate(entity.getClosureDate());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setObs(entity.getObs());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    @Override
    public Cashier convertToEntity(CashierDto dto) {
        Cashier entity = new Cashier();
        entity.setId(dto.getId());
        entity.setOpenDate(dto.getOpenDate());
        entity.setClosureDate(dto.getClosureDate());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setObs(dto.getObs());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}