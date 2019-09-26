package com.example.Restaurant.mapper;

import com.example.Restaurant.domain.Product;
import com.example.Restaurant.domain.ProductItem;
import com.example.Restaurant.dto.ItemDto;
import com.example.Restaurant.dto.ProductDto;
import com.example.Restaurant.dto.ProductItemDto;
import org.modelmapper.ModelMapper;

public class ProductMapper implements GenericMapper<Product, ProductDto> {

    ModelMapper modelMapper = new ModelMapper();

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
                    ProductItemDto productItemDto = new ProductItemDto();

                    productItemDto.setId(productItem.getId());

                    ProductDto pdto = new ProductDto();
                    pdto.setId(productItem.getProduct().getId());
                    productItemDto.setProductDto(modelMapper.map(productItem.getProduct(), ProductDto.class));

                    ItemDto itemDto = new ItemDto();
                    itemDto.setId(productItem.getItem().getId());
                    productItemDto.setItemDto(modelMapper.map(productItem.getItem(), ItemDto.class));

                    productItemDto.setQtde(productItem.getQtde());

                    dto.getProductItemDtos().add(productItemDto);
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
                entity.getItemproduto().add(converterProdutoItemEntity(productItemDto));
            });
        }
        return entity;
    }

    private ProductItem converterProdutoItemEntity(ProductItemDto productItemDto) {
        ProductItem entity = new ProductItem();
        entity.setId(productItemDto.getId());
        entity.setProduct(modelMapper.map(productItemDto.getProductDto(), Product.class));
        if (productItemDto.getItemDto() != null) {
            entity.setItem(new ItemMapper().convertToEntity(productItemDto.getItemDto()));
        }
        entity.setQtde(productItemDto.getQtde());
        return entity;

    }
}