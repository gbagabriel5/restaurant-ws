package com.example.Restaurant.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item implements BaseEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itcod", nullable = false)
    private Integer id;

    @Column(name = "itnome")
    private String name;

    @Column(name = "itpreco")
    private Double price;

    @Column(name = "itcusto")
    private Double cost;

    @Column(name = "itunmed")
    private String unit;

    @Column(name = "itest")
    private Double quantity;

    @Column(name = "itestm")
    private Double minQuantity;

    @Column(name = "itvalidade")
    private Integer shelfLife;

    @Column(name = "itstatus")
    private String status;

    @JoinColumn(name = "proforcod")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Provider provider;

    @JoinColumn(name = "itcticod")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private  ItemCategory itemCategory;
}