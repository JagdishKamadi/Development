package com.epam.controller;

import com.epam.dto.BookDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/library/books")
public class BookControllerWebClient {
    private WebClient bookWebClient;

    @PostConstruct
    public void init() {
        bookWebClient = WebClient.builder()
                .baseUrl("http://localhost:8080/books")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
            }


    @GetMapping
    public Flux<BookDTO> getBooks()
    {
        return bookWebClient.get()
                .uri("/")
                .retrieve()
                .bodyToFlux(BookDTO.class);
    }

    @GetMapping("/{book_id}")
    public Mono<BookDTO> getBook(@PathVariable("book_id") String bookId)
    {
        return bookWebClient.get()
                .uri("/"+bookId)
                .retrieve()
                .bodyToMono(BookDTO.class);
    }

    @PostMapping
    public Mono<BookDTO> addBook(@RequestBody BookDTO bookDTO)
    {
        return bookWebClient.post()
                .uri("/")
                .bodyValue(bookDTO)
                .retrieve()
                .bodyToMono(BookDTO.class);
    }

    @DeleteMapping("/{books_id}")
    public Mono<String> deleteBook(@PathVariable("books_id") String bookId)
    {
        return bookWebClient.delete()
                .uri("/"+bookId)
                .retrieve()
                .bodyToMono(String.class);
    }


    @PutMapping("/{book_id}")
    public Mono<BookDTO> updateBook(@PathVariable("book_id") String bookId,@RequestBody BookDTO bookDTO)
    {
        bookDTO.setBookId(Integer.parseInt(bookId));
        return bookWebClient.post()
                .uri("/")
                .bodyValue(bookDTO)
                .retrieve()
                .bodyToMono(BookDTO.class);
    }


}
