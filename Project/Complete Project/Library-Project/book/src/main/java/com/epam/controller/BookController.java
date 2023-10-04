package com.epam.controller;

import com.epam.dto.BookDTO;
import com.epam.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooks() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/{book_id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable("book_id") String bookId) {
        return new ResponseEntity<>(bookService.getBook(Integer.parseInt(bookId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity<>(bookService.addBook(bookDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{book_id}")
    public ResponseEntity<String> deleteBook(@PathVariable("book_id") String bookId) {
        bookService.deleteBook(Integer.parseInt(bookId));
        return new ResponseEntity<>("Book deleted successfully for id " + bookId, HttpStatus.OK);
    }

    @PutMapping("/{book_id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable("book_id") String bookId,@RequestBody BookDTO bookDTO)
    {
        bookDTO.setBookId(Integer.parseInt(bookId));
        return new ResponseEntity<>(bookService.updateBook(bookDTO),HttpStatus.OK);
    }

}
