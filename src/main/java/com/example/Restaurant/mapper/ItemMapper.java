package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.Item;
import com.example.Restaurant.dto.ItemDto;

public class ItemMapper implements GenericMapper<Item, ItemDto> {

    @Override
    public ItemDto convertToDTO(Item entity) {
        ItemDto dto = new ItemDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setCost(entity.getCost());
        dto.setUnit(entity.getUnit());
        dto.setQuantity(entity.getQuantity());
        dto.setMinQuantity(entity.getMinQuantity());
        dto.setShelfLife(entity.getShelfLife());
        dto.setStatus(entity.getStatus());
        if(entity.getProvider() !=null) {
            dto.setProviderDto(new ProviderMapper().convertToDTO(entity.getProvider()));
        }
        if (entity.getItemCategory() != null) {
            dto.setItemCategoryDto(new ItemCategoryMapper().convertToDTO(entity.getItemCategory()));
        }
        return dto;
    }

    @Override
    public Item convertToEntity(ItemDto dto) {
        Item entity = new Item();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setCost(dto.getCost());
        entity.setUnit(dto.getUnit());
        entity.setQuantity(dto.getQuantity());
        entity.setMinQuantity(dto.getMinQuantity());
        entity.setShelfLife(dto.getShelfLife());
        entity.setStatus(dto.getStatus());
        if(dto.getProviderDto() !=null) {
            entity.setProvider(new ProviderMapper().convertToEntity(dto.getProviderDto()));
        }
        if (dto.getItemCategoryDto() != null) {
            entity.setItemCategory(new ItemCategoryMapper().convertToEntity(dto.getItemCategoryDto()));
        }
        return entity;
    }
}