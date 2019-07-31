package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.Provider;
import com.example.Restaurant.dto.ProviderDto;

public class ProviderMapper implements GenericMapper<Provider, ProviderDto> {

    @Override
    public ProviderDto convertToDTO(Provider entity) {
        ProviderDto dto = new ProviderDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCnpj(entity.getCnpj());
        dto.setCep(entity.getCep());
        dto.setAdress(entity.getAdress());
        dto.setFone(entity.getFone());
        return dto;
    }

    @Override
    public Provider convertToEntity(ProviderDto dto) {
        Provider entity = new Provider();
        entity.setId(dto.getId());
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCep(dto.getCep());
        entity.setAdress(dto.getAdress());
        entity.setAdress(dto.getAdress());
        entity.setFone(dto.getFone());
        return entity;
    }
}