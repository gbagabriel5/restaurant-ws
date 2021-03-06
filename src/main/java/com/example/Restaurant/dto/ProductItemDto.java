package com.example.Restaurant.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductItemDto extends BaseDto {

    private Integer id;

    private ProductDto productDto;

    private ItemDto itemDto;

    private Double qtde;
}