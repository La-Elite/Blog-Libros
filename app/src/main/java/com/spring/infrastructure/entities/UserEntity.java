package com.spring.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "user", length = 100)
    private String id;

    @Column(name = "pass", length = 100)
    private String pass;

    @OneToMany(mappedBy = "userEntity")
    private Set<ReviewEntity> reviews = new LinkedHashSet<>();

    public UserEntity(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }
}