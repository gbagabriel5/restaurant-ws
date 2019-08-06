package com.example.Restaurant.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemCategoryDto extends BaseDto{
    private Integer id;
    private String description;
}