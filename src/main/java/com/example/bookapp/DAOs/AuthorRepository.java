package com.example.bookapp.DAOs;

import com.example.bookapp.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findAll();
    List<Author> findByName(String name);
    Author findByAuthorId(Long id);

}
