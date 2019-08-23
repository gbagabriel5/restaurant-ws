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
@Table(name = "venda")
public class Sale implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vencod", nullable = false)
    private Integer id;

    @JoinColumn(name = "vencxcod")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cashier cashier;

    @JoinColumn(name = "venmcod")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tables tables;

    @Column(name = "vendata")
    private String date;

    @Column(name = "hora")
    private String hour;

    @Column(name = "ventotal")
    private Double total;

    @Column(name = "pagamento")
    private String payment;

    @Column(name = "vrecebido")
    private Double moneyRecievid;

    @Column(name = "troco")
    private Double change;

    @Column(name = "venstatus")
    private String status;

    @Column(name = "vensaida")
    private Double out;

    @Column(name = "vendesc")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemSale> product = new HashSet<>(0);
}