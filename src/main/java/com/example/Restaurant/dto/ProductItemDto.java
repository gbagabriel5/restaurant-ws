package com.example.Restaurant.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductItemDto extends BaseDto {
    private Integer id;
    private ItemDto item;
}