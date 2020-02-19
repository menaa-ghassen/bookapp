package com.example.bookapp.controllers;

import com.example.bookapp.entities.Stock;
import com.example.bookapp.services.BookService;
import com.example.bookapp.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {
    @Autowired
    private StockService stockService;
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/stock/{libName}&{bookName}")
    public List<Stock> getStock(@PathVariable(value = "libName") String libName, @PathVariable(value = "bookName") String bookName) {
        return stockService.getLibraryByLibraryNameAndBookName(libName, bookName);
    }

    @PutMapping(value = "/stock/update")
    public boolean updateStock(@RequestBody Stock stock) {
        return stockService.updateStock(stock);
    }
}
