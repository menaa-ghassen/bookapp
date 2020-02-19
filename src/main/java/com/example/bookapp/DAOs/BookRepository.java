package com.example.bookapp.DAOs;

import com.example.bookapp.entities.Author;
import com.example.bookapp.entities.Book;
import com.example.bookapp.entities.Magazine;
import com.example.bookapp.entities.Novel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();

    void deleteByBookId(Long id);

    List<Book> findAllByAuthorName(String name);

    Book findByBookId(Long id);

    //novels
    List<Novel> findFirstByAuthorOrderByTotalUnitSoldDesc(Author author);
}
