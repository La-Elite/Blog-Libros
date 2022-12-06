package com.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private String id;
    private String title;
    private String author;
    private String image;
    private String description;
    private String category;
    private List<Review> reviews = new ArrayList<>();

}
