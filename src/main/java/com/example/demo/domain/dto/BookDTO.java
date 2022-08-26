package com.example.demo.domain.dto;

import com.example.demo.domain.entiry.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class BookDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    private String book_name;

    public BookDTO(Book book) {

        this.book_id = book.getBook_id();
        this.book_name = "[" + book.getBook_name() + "]";

    }

}
