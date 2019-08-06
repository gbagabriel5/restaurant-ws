package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.Product;
import com.example.Restaurant.dto.ProductCategoryDto;
import com.example.Restaurant.dto.ProductDto;

public class ProductMapper implements GenericMapper<Product, ProductDto> {

    @Override
    public ProductDto convertToDTO(Product entity) {
        ProductDto dto = new ProductDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setCost(entity.getCost());
        dto.setUnit(entity.getUnit());
        dto.setQuantity(entity.getQuantity());
        dto.setMinQuantity(entity.getMinQuantity());
        dto.setStatus(entity.getStatus());
        if (entity.getProductCategory() != null) {
            dto.setProductCategoryDto(new ProductCategoryMapper().convertToDTO(entity.getProductCategory()));
        }
        return dto;
    }

    @Override
    public Product convertToEntity(ProductDto dto) {
        Product entity = new Product();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setCost(dto.getCost());
        entity.setUnit(dto.getUnit());
        entity.setQuantity(dto.getQuantity());
        entity.setMinQuantity(dto.getMinQuantity());
        entity.setStatus(dto.getStatus());
        if (dto.getProductCategoryDto() != null) {
            entity.setProductCategory(new ProductCategoryMapper().convertToEntity(dto.getProductCategoryDto()));
        }
        return entity;
    }
}