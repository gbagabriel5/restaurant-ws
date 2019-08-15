package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.ProductItem;
import com.example.Restaurant.dto.ProductItemDto;

public final class ProductItemMapper implements GenericMapper<ProductItem, ProductItemDto> {

    @Override
    public ProductItemDto convertToDTO(ProductItem entity) {
        ProductItemDto dto = new ProductItemDto();
        dto.setId(entity.getId());
        if (dto.getProductDto() != null) {
            entity.setProduct(new ProductMapper().convertToEntity(dto.getProductDto()));
        }
        if (dto.getItemDto() != null) {
            entity.setItem(new ItemMapper().convertToEntity(dto.getItemDto()));
        }
        return dto;
    }

    @Override
    public ProductItem convertToEntity(ProductItemDto dto) {
        ProductItem entity = new ProductItem();
        entity.setId(dto.getId());
        if (entity.getProduct() != null) {
            dto.setProductDto(new ProductMapper().convertToDTO(entity.getProduct()));
        }
        if (entity.getItem() != null) {
            dto.setItemDto(new ItemMapper().convertToDTO(entity.getItem()));
        }
        return entity;
    }
}
