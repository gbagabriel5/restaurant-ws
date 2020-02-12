package com.example.Restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String type;
}
