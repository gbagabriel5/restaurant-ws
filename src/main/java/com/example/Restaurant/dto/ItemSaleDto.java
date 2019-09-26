package com.example.Restaurant.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemSaleDto extends BaseDto {
    private Integer id;
    private SaleDto saleDto;
    private ProductDto productDto;
    private Integer quantity;
    private String obs;
}