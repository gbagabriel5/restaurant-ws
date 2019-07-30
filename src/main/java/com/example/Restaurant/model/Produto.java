package com.example.Restaurant.model;

import com.example.Restaurant.dto.ProdutoDto;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "procod", nullable = false)
    private Integer cod;

    private String pronome;

    private Double propreco;

    private Double procusto;

    private Integer proestoque;

    private Integer proestm;

    private String prostatus;

    @JoinColumn(name = "progrpcod")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GrupoProduto grupoProduto;

    @JoinColumn(name = "proforcod")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Fornecedor fornecedor;

    public Produto(ProdutoDto produtoDto){
        this.cod = produtoDto.getCod();
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