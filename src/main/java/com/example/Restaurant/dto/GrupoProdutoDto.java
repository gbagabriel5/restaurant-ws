package com.example.Restaurant.dto;

import com.example.Restaurant.model.GrupoProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GrupoProdutoDto {
    @Id
    private Integer grpcod;

    private String grpdesc;

    public GrupoProdutoDto(GrupoProduto grupoProduto){
        this.grpcod = grupoProduto.getGrpcod();
        this.grpdesc = grupoProduto.getGrpdesc();
    }

    public GrupoProduto toModel(){
        return new GrupoProduto(this);
    }
}
