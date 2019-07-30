package com.example.Restaurant.dto;

import com.example.Restaurant.model.Caixa;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CaixaDto {
    private Integer cod;

    private String cxdthabre;

    private String cxdthfecha;

    private Double cxsinicial;

    private Double cxsfinal;

    private String cxobs;

    private String cxstatus;

    public CaixaDto(Caixa caixa){
        this.cod= caixa.getCod();
        this.cxdthabre = caixa.getCxdthabre();
        this.cxdthfecha = caixa.getCxdthfecha();
        this.cxsinicial = caixa.getCxsinicial();
        this.cxsfinal = caixa.getCxsfinal();
        this.cxobs = caixa.getCxobs();
        this.cxstatus = caixa.getCxstatus();
    }
    public Caixa toModel(){return new Caixa(this);}
}