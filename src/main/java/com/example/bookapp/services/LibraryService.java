package com.example.bookapp.services;

import com.example.bookapp.entities.Library;

import java.util.List;

public interface LibraryService {
    void createLibrary(Library library);

    void updateLibrary(Library library);

    void deleteLibrary(Long id);

    List<Library> getLibraries();

    Library getLibraryById(Long id);
}
