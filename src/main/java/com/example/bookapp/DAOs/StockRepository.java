package com.example.bookapp.DAOs;

import com.example.bookapp.entities.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
    List<Stock> findAllByLibrary_Name(String name);

    List<Stock> findByLibrary_NameAndBook_Name(String libraryName, String bookName);

    List<Stock> findAll();

    Stock findStockById(Long id);
}
