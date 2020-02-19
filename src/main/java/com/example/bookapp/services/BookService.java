package com.example.bookapp.services;

import com.example.bookapp.entities.Author;
import com.example.bookapp.entities.Book;
import com.example.bookapp.entities.Magazine;
import com.example.bookapp.entities.Novel;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    List<Book> getAllBooksByAuthorName(String name);

    void createBook(Book book);

    void updateBook(Book book);

    void deleteBookById(Long id);

    Book getBookById(Long id);

    List<Novel> getMostSoldNovelByAuthor(Author author);

    List<Book> getBookByLibraryName(String Name);

    Magazine getClosestReleaseCookingMagazine();
}
