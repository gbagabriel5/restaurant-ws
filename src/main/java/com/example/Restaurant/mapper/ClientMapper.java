package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.Client;
import com.example.Restaurant.dto.ClientDto;

public class ClientMapper implements GenericMapper<Client, ClientDto> {

    @Override
    public ClientDto convertToDTO(Client entity) {
        ClientDto dto = new ClientDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setRg(entity.getRg());
        dto.setCpf(entity.getCpf());
        dto.setAdress(entity.getAdress());
        dto.setFone(entity.getFone());
        return dto;
    }

    @Override
    public Client convertToEntity(ClientDto dto) {
        Client entity = new Client();
        entity.setId(dto.getId());
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setRg(dto.getRg());
        entity.setCpf(dto.getCpf());
        entity.setAdress(dto.getAdress());
        entity.setFone(dto.getFone());
        return entity;
    }
}