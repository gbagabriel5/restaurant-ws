package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.Product;
import com.example.Restaurant.dto.ProductDto;

public class ProductMapper implements GenericMapper<Product, ProductDto> {

    @Override
    public ProductDto convertToDTO(Product entity) {
        ProductDto dto = new ProductDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setCost(entity.getCost());
        dto.setQuantity(entity.getQuantity());
        dto.setMinQuantity(entity.getMinQuantity());
        dto.setStatus(entity.getStatus());
        if (entity.getProductGroup() != null) {
            dto.setProductGroupDto(new ProductGroupMapper().convertToDTO(entity.getProductGroup()));
        }
        if (entity.getProvider() != null) {
            dto.setProviderDto(new ProviderMapper().convertToDTO(entity.getProvider()));
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
        entity.setQuantity(dto.getQuantity());
        entity.setMinQuantity(dto.getMinQuantity());
        entity.setStatus(dto.getStatus());
        if (dto.getProductGroupDto() != null) {
            entity.setProductGroup(new ProductGroupMapper().convertToEntity(dto.getProductGroupDto()));
        }
        if (dto.getProviderDto() != null) {
            entity.setProvider(new ProviderMapper().convertToEntity(dto.getProviderDto()));
        }
        return entity;
    }
}