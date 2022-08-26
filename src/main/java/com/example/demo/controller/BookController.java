package com.example.demo.controller;

import com.example.demo.domain.entiry.Book;
import com.example.demo.exception.CommonErrorResponse;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam("id") String query){
        return new ResponseEntity<>(bookService.searchBook(query), HttpStatus.OK);
    }

    @GetMapping("/searchAll")
    public ResponseEntity<List<Book[]>> searchBooks(){
        return new ResponseEntity<>(bookService.searchAllBook(), HttpStatus.OK);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNoutFoundHandler() {
        return new ResponseEntity<>(new CommonErrorResponse("cannot find that resource"), HttpStatus.NOT_FOUND);
    }
}