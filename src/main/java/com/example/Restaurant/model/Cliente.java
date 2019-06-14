package com.example.Restaurant.model;

import com.example.Restaurant.dto.ClienteDto;
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
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clicod;

    private String clinome;

    private String clirg;

    private String clicpf;

    private String cliend;

    private String clifone;

    public Cliente (ClienteDto clienteDto){
        this.clicod = clienteDto.getClicod();
        this.clinome = clienteDto.getClinome();
        this.clirg = clienteDto.getClirg();
        this.clicpf = clienteDto.getClicpf();
        this.cliend = clienteDto.getCliend();
        this.clifone = clienteDto.getClifone();
    }

    public ClienteDto toDto(){return new ClienteDto(this);}
}
