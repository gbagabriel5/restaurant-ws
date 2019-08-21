package com.example.Restaurant.dto.CustomDto;

import com.example.Restaurant.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCustomDto extends BaseDto{
    private Integer id;
    private String name;
}