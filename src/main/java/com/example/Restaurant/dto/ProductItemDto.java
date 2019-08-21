package com.example.Restaurant.dto;

import com.example.Restaurant.dto.CustomDto.ProductCustomDto;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductItemDto extends BaseDto {

    private Integer id;

    private ProductCustomDto productDto;

    private ItemDto itemDto;

    private Double qtde;
}