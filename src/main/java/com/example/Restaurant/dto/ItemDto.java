package com.example.Restaurant.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto extends BaseDto{
    private Integer id;
    private String name;
    private Double price;
    private Double cost;
    private String unit;
    private Double quantity;
    private Double minQuantity;
    private Integer shelfLife;
    private String status;
    private ProviderDto providerDto;
    private ItemCategoryDto itemCategoryDto;
}