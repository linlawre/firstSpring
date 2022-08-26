package com.example.demo.controller;

import com.example.demo.domain.entiry.Author;
import com.example.demo.exception.CommonErrorResponse;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

//    @GetMapping("/search")
//    public ResponseEntity<List<Author>> searchAuthor(@RequestParam("id") String query){
//        return ResponseEntity.ok(authorService.searchAuthor(query));
//    }
    @GetMapping("/search")
    public ResponseEntity<List<Author>> searchBooks(@RequestParam("id") String query){
        return new ResponseEntity<>(authorService.searchAuthor(query), HttpStatus.OK);
    }

    @GetMapping("/searchAll")
    public ResponseEntity<List<Author[]>> searchBooks(){
        return new ResponseEntity<>(authorService.searchAllAuthor(), HttpStatus.OK);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNoutFoundHandler() {
        return new ResponseEntity<>(new CommonErrorResponse("cannot find that resource"), HttpStatus.NOT_FOUND);
    }
}