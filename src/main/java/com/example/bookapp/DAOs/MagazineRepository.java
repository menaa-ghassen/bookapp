package com.example.bookapp.DAOs;

import com.example.bookapp.entities.BookCategory;
import com.example.bookapp.entities.Magazine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazineRepository extends CrudRepository<Magazine, Long> {
    Magazine findFirstByCategoryOrderByNetReleaseDate(BookCategory category);
}
