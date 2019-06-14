package com.example.Restaurant.dto;

import com.example.Restaurant.model.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FornecedorDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer forcod;

    private String fornome;

    private String forcnpj;

    private String forcep;

    private String forend;

    private String forfone;

    public FornecedorDto (Fornecedor fornecedor){
        this.forcod = fornecedor.getForcod();
        this.fornome = fornecedor.getFornome();
        this.forcnpj = fornecedor.getForcnpj();
        this.forcep = fornecedor.getForcep();
        this.forend = fornecedor.getForend();
        this.forfone = fornecedor.getForfone();
    }

    public Fornecedor toModel(){return new Fornecedor(this);}
}
