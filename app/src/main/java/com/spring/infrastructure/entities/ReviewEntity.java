package com.spring.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@Table(name = "review")
public class ReviewEntity {

    public ReviewEntity(UserEntity userEntity, BookEntity book, String message, LocalDate date) {
        this.userEntity = userEntity;
        this.book = book;
        this.message = message;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book")
    private BookEntity book;

    @Column(name = "message", length = 100)
    private String message;

    @Column(name = "date")
    private LocalDate date;


}