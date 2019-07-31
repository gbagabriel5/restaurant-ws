package com.example.Restaurant.dto;

import lombok.*;

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
    private Integer quantity;
    private Integer minQuantity;
    private String status;
    private ProductGroupDto productGroupDto;
    private ProviderDto providerDto;
}