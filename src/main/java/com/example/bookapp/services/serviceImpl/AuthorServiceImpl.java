package com.example.bookapp.services.serviceImpl;

import com.example.bookapp.DAOs.AuthorRepository;
import com.example.bookapp.entities.Author;
import com.example.bookapp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public String addAuthor(Author author) {
        /*if(authorRepository.findByAuthorId(author.getAuthorId())!=null){
            return "This author already exists ";
        }*/
        authorRepository.save(author);
        return "Author saved successfully ";
    }
}
