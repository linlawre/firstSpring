package com.example.demo.service;

import com.example.demo.domain.dto.BookDTO;
import com.example.demo.domain.entiry.Book;

import java.util.List;

public interface BookService {
    List<Book> searchBook(String query);
    List<Book[]> searchAllBook();
    Book createBook(Book book);
}