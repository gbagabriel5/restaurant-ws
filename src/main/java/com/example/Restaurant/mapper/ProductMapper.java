package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.Product;
import com.example.Restaurant.domain.ProductItem;
import com.example.Restaurant.dto.ProductDto;
import com.example.Restaurant.dto.ProductItemDto;

public class ProductMapper implements GenericMapper<Product, ProductDto> {

    private ProductItemMapper productItemMapper = new ProductItemMapper();

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

        if(!entity.getItemproduto().isEmpty()){
            entity.getItemproduto().forEach(productItem -> {
                dto.getProductItemDtos().add( productItemMapper.convertToDTO(productItem));
            });
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

        if(!dto.getProductItemDtos().isEmpty()){
            dto.getProductItemDtos().forEach(productItemDto -> {
                entity.getItemproduto().add( converterProdutoItemEntity(productItemDto));
            });
        }
        return entity;
    }

    private ProductItem converterProdutoItemEntity(ProductItemDto productItemDto) {
        ProductItem entity = new ProductItem();
        entity.setId(productItemDto.getId());
        if (productItemDto.getProductDto() != null) {
            entity.setProduct(new ProductMapper().convertToEntity(productItemDto.getProductDto()));
        }
        if (productItemDto.getItemDto() != null) {
            entity.setItem(new ItemMapper().convertToEntity(productItemDto.getItemDto()));
        }
        return entity;

    }

    private ProductItemDto converterProdutoItemDto(ProductItem entity) {
        ProductItemDto dto = new ProductItemDto();

        dto.setId(entity.getId());

        if (entity.getProduct() != null) {
            dto.setProductDto(new ProductMapper().convertToDTO(entity.getProduct()));
        }
        if (entity.getItem() != null) {
            dto.setItemDto(new ItemMapper().convertToDTO(entity.getItem()));
        }
        return dto;

    }
}