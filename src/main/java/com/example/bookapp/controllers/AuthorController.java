package com.example.bookapp.controllers;

import com.example.bookapp.entities.Author;
import com.example.bookapp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/author/add")
    public String addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }
}
