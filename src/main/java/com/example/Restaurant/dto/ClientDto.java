package com.example.Restaurant.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto extends BaseDto{
    private Integer id;
    private String name;
    private String rg;
    private String cpf;
    private String adress;
    private String fone;
}