package com.example.Restaurant.domain;

import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "itemvenda")
public class ItemSale implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itvcod", unique = true, nullable = false)
    private Integer id;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itvvencod", nullable = false)
    private Sale sale;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itvprocod", nullable = false)
    private Product product;

    @Column(name = "itvqtde")
    private Integer quantity;

    @Column(name = "itvobs")
    private String obs;
}