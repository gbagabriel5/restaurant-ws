package com.example.Restaurant.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fornecedor")
public class Provider implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "forcod", nullable = false)
    private Integer id;

    @Column(name = "fornome")
    private String name;

    @Column(name = "forcnpj")
    private String cnpj;

    @Column(name = "forcep")
    private String cep;

    @Column(name = "forend")
    private String adress;

    @Column(name = "forfone")
    private String fone;
}