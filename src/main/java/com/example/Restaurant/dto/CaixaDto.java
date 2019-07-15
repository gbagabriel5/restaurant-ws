package com.example.Restaurant.dto;

import com.example.Restaurant.model.Caixa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CaixaDto {
    @Id
    private Integer cxcod;

    private String cxdthabre;

    private String cxdthfecha;

    private Double cxsinicial;

    private Double cxsfinal;

    private String cxobs;

    private String cxstatus;

    public CaixaDto(Caixa caixa){
        this.cxcod= caixa.getCxcod();
        this.cxdthabre = caixa.getCxdthabre();
        this.cxdthfecha = caixa.getCxdthfecha();
        this.cxsinicial = caixa.getCxsinicial();
        this.cxsfinal = caixa.getCxsfinal();
        this.cxobs = caixa.getCxobs();
        this.cxstatus = caixa.getCxstatus();
    }

    public Caixa toModel(){return new Caixa(this);}
}
