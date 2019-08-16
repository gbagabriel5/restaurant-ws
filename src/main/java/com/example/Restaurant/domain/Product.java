package com.example.Restaurant.domain;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "proest")
    private Integer quantity;

    @Column(name = "proestm")
    private Integer minQuantity;

    @Column(name = "prostatus")
    private String status;

    @Column(name = "procts")
    private String control;

    @JoinColumn(name = "proctpcod")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductCategory  productCategory;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductItem>  itemproduto = new HashSet<>(0);
}