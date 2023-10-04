package com.epam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "book_id" }) })
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer libraryId;
    private String username;
    @Column(name="book_id")
    private Integer bookId;

    public Library(String username, Integer bookId) {
        this.username = username;
        this.bookId = bookId;
    }
}
