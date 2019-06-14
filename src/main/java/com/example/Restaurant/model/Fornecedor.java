package com.example.Restaurant.model;

import com.example.Restaurant.dto.FornecedorDto;
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
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer forcod;

    private String fornome;

    private String forcnpj;

    private String forcep;

    private String forend;

    private String forfone;



    public Fornecedor(FornecedorDto fornecedorDto) {
        this.forcod = fornecedorDto.getForcod();
        this.fornome = fornecedorDto.getFornome();
        this.forcnpj = fornecedorDto.getForcnpj();
        this.forcep = fornecedorDto.getForcep();
        this.forend = fornecedorDto.getForend();
        this.forfone = fornecedorDto.getForfone();
    }

    public FornecedorDto toDto() {
        return new FornecedorDto(this);
    }
}
