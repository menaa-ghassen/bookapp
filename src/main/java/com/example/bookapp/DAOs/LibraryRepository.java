package com.example.bookapp.DAOs;

import com.example.bookapp.entities.Library;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Long> {
    List<Library> findAll();

    List<Library> findLibraryByName(String name);

    Library findLibraryByLibraryId(Long id);
}
