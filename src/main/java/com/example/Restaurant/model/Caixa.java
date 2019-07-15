package com.example.Restaurant.model;

import com.example.Restaurant.dto.CaixaDto;
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
@Table(name = "caixa")
public class Caixa {
    @Id
    private Integer cxcod;

    private String cxdthabre;

    private String cxdthfecha;

    private Double cxsinicial;

    private Double cxsfinal;

    private String cxobs;

    private String cxstatus;

    public Caixa(CaixaDto caixaDto) {
        this.cxcod = caixaDto.getCxcod();
        this.cxdthabre = caixaDto.getCxdthabre();
        this.cxdthfecha = caixaDto.getCxdthfecha();
        this.cxsinicial = caixaDto.getCxsinicial();
        this.cxsfinal = caixaDto.getCxsfinal();
        this.cxobs = caixaDto.getCxobs();
        this.cxstatus = caixaDto.getCxstatus();
    }

    public CaixaDto toDto() {
        return new CaixaDto(this);
    }

}
