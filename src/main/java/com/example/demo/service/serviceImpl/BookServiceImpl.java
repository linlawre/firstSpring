package com.example.demo.service.serviceImpl;

import com.example.demo.domain.dto.BookDTO;
import com.example.demo.domain.entiry.Book;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> searchBook(String query) {
        List<Book> books = bookRepository.searchProductsSQL(query);
        if (books.isEmpty()) {
            throw new ResourceNotFoundException(".....");
        }

        return books;
    }

    @Override
    public List<Book[]> searchAllBook() {
        List<Book[]> books = bookRepository.getAll();
        return books;
    }
    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}