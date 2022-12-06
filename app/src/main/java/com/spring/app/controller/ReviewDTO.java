package com.spring.app.controller;


public record ReviewDTO(
        String user,
        String bookIsbn,
        String message) {
}
