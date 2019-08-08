package com.example.Restaurant.dto;

import com.example.Restaurant.domain.Product;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemSaleDto extends BaseDto {
    private Integer id;
    private Product product;
    private Integer quantity;
    private String obs;
}