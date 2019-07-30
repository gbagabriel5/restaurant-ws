package com.example.Restaurant.model;

import com.example.Restaurant.dto.CaixaDto;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "caixa")
public class Caixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cxcod", nullable = false)
    private Integer cod;

    private String cxdthabre;

    private String cxdthfecha;

    private Double cxsinicial;

    private Double cxsfinal;

    private String cxobs;

    private String cxstatus;

    public Caixa(CaixaDto caixaDto) {
        this.cod = caixaDto.getCod();
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