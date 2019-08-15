package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.Product;
import com.example.Restaurant.domain.ProductItem;
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
        dto.setControl(entity.getControl());
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
        entity.setQuantity(dto.getQuantity());
        entity.setMinQuantity(dto.getMinQuantity());
        entity.setStatus(dto.getStatus());
        entity.setControl(dto.getControl());
        if (dto.getProductCategoryDto() != null) {
            entity.setProductCategory(new ProductCategoryMapper().convertToEntity(dto.getProductCategoryDto()));
        }
        return entity;
    }

    public Product convertToEntityToDtoCreate(ProductDto dto) {
        Product entity = new Product();

        dto.getProductItemDtos().forEach(productItemDto -> {
            ProductItem productItem = new ProductItem();
            productItem.setId(dto.getId());
            if (productItem.getProduct() != null) {
                productItem.setProduct(new ProductMapper().convertToEntity(productItemDto.getProductDto()));
            }
            if (productItem.getItem() != null) {
                productItem.setItem(new ItemMapper().convertToEntity(productItemDto.getItemDto()));
            }
            entity.getProductItems().add(productItem);
        });
        return entity;
    }
}