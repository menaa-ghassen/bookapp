package com.example.bookapp.services;

import com.example.bookapp.entities.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    String addAuthor(Author author);
}
