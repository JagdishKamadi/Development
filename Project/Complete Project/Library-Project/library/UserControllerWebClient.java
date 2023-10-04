package com.epam.controller;


import com.epam.dto.LibraryDTO;
import com.epam.dto.UserDTO;
import com.epam.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/library/users")
public class UserControllerWebClient {

    private WebClient userWebClient;

    @Autowired
    private LibraryService libraryService;

    @PostConstruct
    public void init() {
        userWebClient = WebClient.builder()
                .baseUrl("http://localhost:8082/users")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @GetMapping
    public Flux<UserDTO> getUsers()
    {
        return userWebClient.get()
                .uri("/")
                .retrieve()
                .bodyToFlux(UserDTO.class);
    }

    @GetMapping("/{username}")
    public Mono<UserDTO> getUser(@PathVariable("username") String username)
    {
        return userWebClient.get()
                .uri("/"+username)
                .retrieve()
                .bodyToMono(UserDTO.class);
    }

    @PostMapping
    public Mono<UserDTO> addUser(@RequestBody UserDTO userDTO)
    {
        return userWebClient.post()
                .uri("/")
                .bodyValue(userDTO)
                .retrieve()
                .bodyToMono(UserDTO.class);
    }

    @DeleteMapping("/{username}")
    public Mono<String> deleteUser(@PathVariable("username") String username)
    {
        return userWebClient.delete()
                .uri("/"+username)
                .retrieve()
                .bodyToMono(String.class);
    }


    @PutMapping
    public Mono<UserDTO> updateUser(@RequestBody UserDTO userDTO)
    {
        return userWebClient.put()
                .uri("/")
                .bodyValue(userDTO)
                .retrieve()
                .bodyToMono(UserDTO.class);
    }

    @PostMapping("/{username}/books/{bookid}")
    public ResponseEntity<LibraryDTO> addAssociation(@PathVariable String username, @PathVariable String bookid)
            throws NumberFormatException{
        LibraryDTO libraryDTO = new LibraryDTO();
        libraryDTO.setUsername(username);
        libraryDTO.setBookId(Integer.parseInt(bookid));
        return new ResponseEntity<>(libraryService.add(libraryDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{username}/books/{bookid}")
    public ResponseEntity<String> deleteAssociation(@PathVariable String username, @PathVariable String bookid)
            throws NumberFormatException{
        LibraryDTO libraryDTO = new LibraryDTO();
        libraryDTO.setUsername(username);
        libraryDTO.setBookId(Integer.parseInt(bookid));
        libraryService.delete(libraryDTO);
        return new ResponseEntity<>("Association deleted successfully",HttpStatus.OK);
    }
}
