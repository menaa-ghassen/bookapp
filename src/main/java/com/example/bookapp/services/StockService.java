package com.example.bookapp.services;

import com.example.bookapp.entities.Stock;

import java.util.List;

public interface StockService {

    boolean updateStock(Stock stock);

    List<Stock> getAll();

    List<Stock> getLibraryByLibraryNameAndBookName(String libraryName, String bookName);
}
