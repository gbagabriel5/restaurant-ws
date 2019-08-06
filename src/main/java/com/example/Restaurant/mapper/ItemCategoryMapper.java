package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.ItemCategory;
import com.example.Restaurant.dto.ItemCategoryDto;

public class ItemCategoryMapper implements GenericMapper<ItemCategory, ItemCategoryDto> {

    @Override
    public ItemCategoryDto convertToDTO(ItemCategory entity) {
        ItemCategoryDto dto = new ItemCategoryDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    @Override
    public ItemCategory convertToEntity(ItemCategoryDto dto) {
        ItemCategory entity = new ItemCategory();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}