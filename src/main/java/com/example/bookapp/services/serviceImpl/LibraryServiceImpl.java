package com.example.bookapp.services.serviceImpl;

import com.example.bookapp.DAOs.LibraryRepository;
import com.example.bookapp.entities.Library;
import com.example.bookapp.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public void createLibrary(Library library) {
        libraryRepository.save(library);
    }

    @Override
    public void updateLibrary(Library library) {

    }

    @Override
    public void deleteLibrary(Long id) {

    }

    @Override
    public List<Library> getLibraries() {
        return libraryRepository.findAll();
    }

    @Override
    public Library getLibraryById(Long id) {
        return libraryRepository.findLibraryByLibraryId(id);
    }
}
