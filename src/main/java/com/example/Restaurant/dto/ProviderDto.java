package com.example.Restaurant.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDto extends BaseDto{
    private Integer id;
    private String name;
    private String cnpj;
    private String cep;
    private String adress;
    private String fone;
}