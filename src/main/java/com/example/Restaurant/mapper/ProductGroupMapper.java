package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.ProductGroup;
import com.example.Restaurant.dto.ProductGroupDto;

public class ProductGroupMapper implements GenericMapper<ProductGroup, ProductGroupDto> {

    @Override
    public ProductGroupDto convertToDTO(ProductGroup entity) {
        ProductGroupDto dto = new ProductGroupDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    @Override
    public ProductGroup convertToEntity(ProductGroupDto dto) {
        ProductGroup entity = new ProductGroup();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}