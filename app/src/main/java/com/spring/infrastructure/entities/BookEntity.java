package com.spring.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isbn", nullable = false, length = 100)
    private String id;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "author", length = 100)
    private String author;

    @Column(name = "image", length = 100)
    private String image;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "category", length = 100)
    private String category;

    @OneToMany(mappedBy = "book")
    private Set<ReviewEntity> reviews = new LinkedHashSet<>();


}