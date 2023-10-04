package com.epam.client;

import com.epam.dto.BookDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "book-app")
@LoadBalancerClient(name="book-app")
public interface BookClient {

	@GetMapping("/books")
	public List<BookDTO> getBooks();

	@GetMapping("/books/{book_id}")
	public BookDTO getBook(@PathVariable("book_id") int bookId);

	@PostMapping("/books")
	public BookDTO addBook(BookDTO bookDto);
	@DeleteMapping("/books/{book_id}")
	public void deleteBook(@PathVariable("book_id") int bookId);

	@PutMapping("/books/{book_id}")
	public BookDTO updateBook(@PathVariable("book_id") int bookId, @RequestBody BookDTO bookDto);



}
