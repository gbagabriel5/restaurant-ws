package com.example.Restaurant.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Client implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clicod", nullable = false)
    private Integer id;

    @Column(name = "clinome")
    private String name;

    @Column(name = "clirg")
    private String rg;

    @Column(name = "clicpf")
    private String cpf;

    @Column(name = "cliend")
    private String adress;

    @Column(name = "clifone")
    private String fone;
}