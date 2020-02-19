package com.example.bookapp.controllers;

import com.example.bookapp.entities.Library;
import com.example.bookapp.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/libraries")
    public List<Library> getAllLibraries(){
        return libraryService.getLibraries();
    }
}
