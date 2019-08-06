package com.example.Restaurant.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Product implements BaseEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "procod", nullable = false)
    private Integer id;

    @Column(name = "pronome")
    private String name;

    @Column(name = "propreco")
    private Double price;

    @Column(name = "procusto")
    private Double cost;

    @Column(name = "prounmed")
    private String unit;

    @Column(name = "proest")
    private Integer quantity;

    @Column(name = "proestm")
    private Integer minQuantity;

    @Column(name = "prostatus")
    private String status;

    @JoinColumn(name = "proctpcod")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductCategory  productCategory;
}