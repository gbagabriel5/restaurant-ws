package com.example.Restaurant.model;

import com.example.Restaurant.dto.ProdutoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer procod;

    private String pronome;

    private Double propreco;

    private Double procusto;

    private Integer proestoque;

    private Integer proestm;

    private String prostatus;

    @ManyToOne()
    @JoinColumn(name = "progrpcod")
    private GrupoProduto grupoProduto;

    @ManyToOne()
    @JoinColumn(name = "proforcod")
    private Fornecedor fornecedor;

    public Produto(ProdutoDto produtoDto){
        this.procod = produtoDto.getProcod();
        this.pronome = produtoDto.getPronome();
        this.propreco = produtoDto.getPropreco();
        this.procusto = produtoDto.getProcusto();
        this.proestoque = produtoDto.getProestoque();
        this.proestm = produtoDto.getProestm();
        this.prostatus = produtoDto.getProstatus();
        if(produtoDto.getGrupoProdutoDto() != null)
            this.grupoProduto = produtoDto.getGrupoProdutoDto().toModel();
//        if(produtoDto.getFornecedorDto() != null)
//            this.fornecedor = produtoDto.getFornecedorDto().toModel();
        setFornecedor(produtoDto.getFornecedorDto().toModel());
    }
    public ProdutoDto toDto(){
        return new ProdutoDto(this);
    }
}
