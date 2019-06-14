package com.example.Restaurant.dto;

import com.example.Restaurant.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteDto {

    @Id
    private Integer clicod;
    private String clinome;
    private String clirg;
    private String clicpf;
    private String cliend;
    private String clifone;

    public ClienteDto (Cliente cliente){
        this.clicod = cliente.getClicod();
        this.clinome = cliente.getClinome();
        this.clirg = cliente.getClirg();
        this.clicpf = cliente.getClicpf();
        this.cliend = cliente.getCliend();
        this.clifone = cliente.getClifone();
    }

    public Cliente toModel(){return new Cliente(this);}
}
