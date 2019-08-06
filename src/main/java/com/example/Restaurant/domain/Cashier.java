package com.example.Restaurant.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "caixa")
public class Cashier implements BaseEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cxcod", nullable = false)
    private Integer id;

    @Column(name = "cxdata")
    private String date;

    @Column(name = "cxdthabre")
    private String openDate;

    @Column(name = "cxdthfecha")
    private String closureDate;

    @Column(name = "cxdesc")
    private String description;

    @Column(name = "cxsinicial")
    private Double startDate;

    @Column(name = "cxsfinal")
    private Double endDate;

    @Column(name = "cxobs")
    private String obs;

    @Column(name = "cxstatus")
    private String status;
}