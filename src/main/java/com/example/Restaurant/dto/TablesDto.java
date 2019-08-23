package com.example.Restaurant.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TablesDto extends BaseDto {
    private Integer id;
    private String status;
}