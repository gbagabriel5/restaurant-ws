package com.example.Restaurant.dto;

import com.example.Restaurant.model.GrupoProduto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GrupoProdutoDto {
    private Integer cod;
    private String grpdesc;

    public GrupoProdutoDto(GrupoProduto grupoProduto){
        this.cod = grupoProduto.getCod();
        this.grpdesc = grupoProduto.getGrpdesc();
    }

    public GrupoProduto toModel(){
        return new GrupoProduto(this);
    }
}
