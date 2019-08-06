package com.example.Restaurant.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoriaproduto")
public class ProductCategory implements BaseEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ctpcod", nullable = false)
    private Integer id;

    @Column(name = "ctpdesc")
    private String description;
}