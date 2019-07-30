package com.example.Restaurant.dto;

import com.example.Restaurant.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoDto {

    private Integer cod;
    private String pronome;
    private Double propreco;
    private Double procusto;
    private Integer proestoque;
    private Integer proestm;
    private String prostatus;
    private GrupoProdutoDto grupoProdutoDto;
    private FornecedorDto fornecedorDto;

    public ProdutoDto(Produto produto){
        this.cod = produto.getCod();
        this.pronome = produto.getPronome();
        this.propreco = produto.getPropreco();
        this.procusto = produto.getProcusto();
        this.proestoque = produto.getProestoque();
        this.proestm = produto.getProestm();
        this.prostatus = produto.getProstatus();
        if(produto.getGrupoProduto() != null)
            this.grupoProdutoDto = produto.getGrupoProduto().toDto();
        if(produto.getFornecedor() != null)
            this.fornecedorDto = produto.getFornecedor().toDto();
    }
    public Produto toModel(){
        return new Produto(this);
    }
}
