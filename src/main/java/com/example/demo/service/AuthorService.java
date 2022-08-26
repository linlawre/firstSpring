package com.example.demo.service;

import com.example.demo.domain.entiry.Author;
import com.example.demo.domain.entiry.Book;

import java.util.List;

public interface AuthorService {

    List<Author> searchAuthor(String query);

    List<Author[]> searchAllAuthor();

    Author createAuthor(Author author);
}