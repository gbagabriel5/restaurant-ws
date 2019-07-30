package com.example.Restaurant.dto;

import com.example.Restaurant.model.Fornecedor;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorDto {

    private Integer cod;

    private String fornome;

    private String forcnpj;

    private String forcep;

    private String forend;

    private String forfone;

    public FornecedorDto (Fornecedor fornecedor){
        this.cod = fornecedor.getCod();
        this.fornome = fornecedor.getFornome();
        this.forcnpj = fornecedor.getForcnpj();
        this.forcep = fornecedor.getForcep();
        this.forend = fornecedor.getForend();
        this.forfone = fornecedor.getForfone();
    }

    public Fornecedor toModel(){return new Fornecedor(this);}
}