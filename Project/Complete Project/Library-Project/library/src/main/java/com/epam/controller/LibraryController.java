package com.epam.controller;

import com.epam.client.BookClient;
import com.epam.client.UserClient;
import com.epam.dto.BookDTO;
import com.epam.dto.LibraryDTO;
import com.epam.dto.UserDTO;
import com.epam.exception.AssociationNotFoundException;
import com.epam.exception.UniqueDetailsException;
import com.epam.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @Autowired
    private BookClient bookClient;

    @Autowired
    private UserClient userClient;


    /**
     * book client
     */
    @GetMapping("/books")
    public List<BookDTO> getBooks() {
        return bookClient.getBooks();
    }

    @GetMapping("/books/{book_id}")
    public BookDTO getBook(@PathVariable("book_id") int bookId) {
        return bookClient.getBook(bookId);

    }

    @PostMapping("/books")
    public BookDTO addBook(@RequestBody BookDTO bookDto) {

        return bookClient.addBook(bookDto);

    }

    @PutMapping("/books/{book_id}")
    public BookDTO book(@RequestBody BookDTO bookDto) {

        return bookClient.addBook(bookDto);
    }

    @DeleteMapping("/books/{book_id}")
    public void deleteBook(@PathVariable("book_id") String bookId) {
        bookClient.deleteBook(Integer.parseInt(bookId));
    }

    /**
     * user client
     */

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userClient.getUsers();
    }

    @GetMapping("/users/{user_name}")
    public UserDTO getUser(@PathVariable("user_name") String userName) {
        return userClient.getUser(userName);
    }

    @PostMapping("/users")
    public UserDTO addUser(@RequestBody UserDTO userDto) {
        return userClient.addUser(userDto);

    }

    @DeleteMapping("/users/{username}")
    public void deleteUser(@PathVariable("username") String username) {
        userClient.deleteUser(username);
    }

    @PutMapping
    public UserDTO updateUser(@RequestBody UserDTO userDto) {
        return userClient.addUser(userDto);
    }


    /**
     * library controller
     *
     * @param username
     * @param bookId
     * @throws AssociationNotFoundException
     * @throws UniqueDetailsException
     */

    @PostMapping("users/{username}/books/{bookid}")
    public ResponseEntity<LibraryDTO> issueBook(@PathVariable("username") String username, @PathVariable("bookid") String bookId) throws NumberFormatException {
        userClient.getUser(username);
        bookClient.getBook(Integer.parseInt(bookId));

        LibraryDTO libraryDTO = new LibraryDTO();
        libraryDTO.setUsername(username);
        libraryDTO.setBookId(Integer.parseInt(bookId));
        return new ResponseEntity<>(libraryService.issueBook(libraryDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("users/{username}/books/{bookid}")
    public ResponseEntity<String> releaseBook(@PathVariable("username") String username, @PathVariable("bookid") String bookId) throws NumberFormatException {

        LibraryDTO libraryDTO = new LibraryDTO();
        libraryDTO.setUsername(username);
        libraryDTO.setBookId(Integer.parseInt(bookId));
        libraryService.releaseBook(libraryDTO);
        return new ResponseEntity<>("Association deleted successfully", HttpStatus.OK);
    }
}
