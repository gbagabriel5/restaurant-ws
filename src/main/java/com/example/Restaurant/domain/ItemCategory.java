package com.example.Restaurant.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoriaitem")
public class ItemCategory implements BaseEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cticod", nullable = false)
    private Integer id;

    @Column(name = "ctinome")
    private String description;
}