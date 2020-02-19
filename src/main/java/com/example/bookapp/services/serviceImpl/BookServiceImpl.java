package com.example.bookapp.services.serviceImpl;

import com.example.bookapp.DAOs.BookRepository;
import com.example.bookapp.DAOs.LibraryRepository;
import com.example.bookapp.DAOs.MagazineRepository;
import com.example.bookapp.DAOs.StockRepository;
import com.example.bookapp.entities.*;
import com.example.bookapp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private MagazineRepository magazineRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getAllBooksByAuthorName(String name) {
        return bookRepository.findAllByAuthorName(name);
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteByBookId(id);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findByBookId(id);
    }

    @Override
    public List<Novel> getMostSoldNovelByAuthor(Author author) {
        return bookRepository.findFirstByAuthorOrderByTotalUnitSoldDesc(author);
    }

    @Override
    public List<Book> getBookByLibraryName(String name) {
        List<Book> booksByLib = new ArrayList<>();
        for (Stock s : stockRepository.findAllByLibrary_Name(name)) {
            booksByLib.add(s.getBook());
        }
        return booksByLib;
    }

    @Override
    public Magazine getClosestReleaseCookingMagazine() {
        return magazineRepository.findFirstByCategoryOrderByNetReleaseDate(BookCategory.Cooking);
    }


}
