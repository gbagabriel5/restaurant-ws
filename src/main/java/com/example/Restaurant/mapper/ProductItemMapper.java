package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.Product;
import com.example.Restaurant.domain.ProductItem;
import com.example.Restaurant.dto.ProductItemDto;

public final class ProductItemMapper implements GenericMapper<ProductItem, ProductItemDto> {

    @Override
    public ProductItemDto convertToDTO(ProductItem entity) {
        ProductItemDto dto = new ProductItemDto();
        dto.setId(entity.getId());
        Product product = entity.getProduct();
        return dto;
    }

    @Override
    public ProductItem convertToEntity(ProductItemDto dto) {
        ProductItem entity = new ProductItem();
        entity.setId(dto.getId());
        return entity;
    }
}
