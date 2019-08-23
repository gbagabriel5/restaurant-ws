package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.Tables;
import com.example.Restaurant.dto.TablesDto;

public class TableMapper implements GenericMapper<Tables, TablesDto> {

    @Override
    public TablesDto convertToDTO(Tables entity) {
        TablesDto dto = new TablesDto();
        dto.setId(entity.getId());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    @Override
    public Tables convertToEntity(TablesDto dto) {
        Tables entity = new Tables();
        entity.setId(dto.getId());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}