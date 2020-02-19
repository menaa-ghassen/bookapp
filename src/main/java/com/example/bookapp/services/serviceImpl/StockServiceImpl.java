package com.example.bookapp.services.serviceImpl;

import com.example.bookapp.DAOs.BookRepository;
import com.example.bookapp.DAOs.StockRepository;
import com.example.bookapp.entities.Stock;
import com.example.bookapp.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public boolean updateStock(Stock stock) {
        boolean isUpdated = false;
        Stock stock1 = stockRepository.findStockById(stock.getId());
        if (stock1 != null) {
            stock1.setQuantity(stock1.getQuantity() - stock.getQuantity());
            stock1.getBook().setTotalUnitSold(stock1.getBook().getTotalUnitSold() + stock.getQuantity());
            bookRepository.save(stock1.getBook());
            stockRepository.save(stock1);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    @Override
    public List<Stock> getLibraryByLibraryNameAndBookName(String libraryName, String bookName) {
        return stockRepository.findByLibrary_NameAndBook_Name(libraryName, bookName);
    }


}
