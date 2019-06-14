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
    private Integer grpcod;

    private String grpdesc;

//    @OneToMany(mappedBy = "grupoProduto", fetch = FetchType.LAZY)
//    private List<GrupoProduto> grupoProdutos;

    public GrupoProduto(GrupoProdutoDto grupoProdutoDto){
        this.grpcod = grupoProdutoDto.getGrpcod();
        this.grpdesc = grupoProdutoDto.getGrpdesc();
    }

    public GrupoProdutoDto toDto(){
        return new GrupoProdutoDto(this);
    }
}
