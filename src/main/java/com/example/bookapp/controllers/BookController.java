package com.example.bookapp.controllers;

import com.example.bookapp.entities.*;
import com.example.bookapp.services.BookService;
import com.example.bookapp.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private StockService stockService;

    @GetMapping("/book/{authorName}")
    public List<Book> getAllBooksByAuthorName(@PathVariable(value = "authorName") String name) {
        return bookService.getAllBooksByAuthorName(name);
    }

    @GetMapping("/novel/most-sold")
    public List<Novel> getMostSoldNovelByAuthor(@RequestBody Author author) {
        return bookService.getMostSoldNovelByAuthor(author);
    }

    @GetMapping("/books/{libraryName}")
    public List<Book> getBookByLibrary(@PathVariable(value = "libraryName") String libraryName) {
        return bookService.getBookByLibraryName(libraryName);
    }

    @GetMapping("/magazine/closest-release-date")
    public Magazine getClosestReleaseCookingMagazine() {
        return bookService.getClosestReleaseCookingMagazine();
    }


}
