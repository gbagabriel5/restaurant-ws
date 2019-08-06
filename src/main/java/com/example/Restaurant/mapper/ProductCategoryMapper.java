package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.ProductCategory;
import com.example.Restaurant.dto.ProductCategoryDto;

public class ProductCategoryMapper implements GenericMapper<ProductCategory, ProductCategoryDto> {

    @Override
    public ProductCategoryDto convertToDTO(ProductCategory entity) {
        ProductCategoryDto dto = new ProductCategoryDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    @Override
    public ProductCategory convertToEntity(ProductCategoryDto dto) {
        ProductCategory entity = new ProductCategory();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}