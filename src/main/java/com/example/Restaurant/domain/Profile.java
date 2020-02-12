package com.example.Restaurant.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "perfil")
public class Profile implements BaseEntity<Integer>, GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pcodigo", nullable = false)
    private Integer id;

    @Column(name = "pnome")
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
