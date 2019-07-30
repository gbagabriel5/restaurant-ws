package com.example.Restaurant.model;

import com.example.Restaurant.dto.GrupoProdutoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "grupoproduto")
public class GrupoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grpcod", nullable = false)
    private Integer cod;

    private String grpdesc;

    public GrupoProduto(GrupoProdutoDto grupoProdutoDto){
        this.cod = grupoProdutoDto.getCod();
        this.grpdesc = grupoProdutoDto.getGrpdesc();
    }

    public GrupoProdutoDto toDto(){
        return new GrupoProdutoDto(this);
    }
}
