package com.example.demo.service.serviceImpl;

import com.example.demo.domain.entiry.Author;
import com.example.demo.domain.entiry.Book;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> searchAuthor(String query) {
        List<Author> author = authorRepository.searchProductsSQL(query);
        if(author.isEmpty()){
            throw new ResourceNotFoundException(".....");
        }
        return author;
    }

    @Override
    public List<Author[]> searchAllAuthor() {
        List<Author[]> author = authorRepository.getAll();
        return author;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }
}