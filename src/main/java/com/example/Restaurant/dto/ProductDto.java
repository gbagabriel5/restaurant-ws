package com.example.Restaurant.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseDto{
    private Integer id;
    private String name;
    private Double price;
    private Double cost;
    private String unit;
    private Integer quantity;
    private Integer minQuantity;
    private String status;
    private ProductCategoryDto productCategoryDto;
    private List<ProductItemDto> productItem;
}