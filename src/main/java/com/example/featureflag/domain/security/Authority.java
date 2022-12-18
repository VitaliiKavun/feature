package com.example.featureflag.domain.security;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String role;
    @ManyToMany
    private Set<UserEntity> users;

}
