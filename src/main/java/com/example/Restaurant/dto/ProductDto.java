package com.example.Restaurant.dto;

import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseDto{
    private Integer id;
    private String name;
    private Double price;
    private Double cost;
    private Integer quantity;
    private Integer minQuantity;
    private String status;
    private String control;
    private ProductCategoryDto productCategoryDto;
    private Set<ProductItemDto> productItemDtos = new HashSet<>();
}