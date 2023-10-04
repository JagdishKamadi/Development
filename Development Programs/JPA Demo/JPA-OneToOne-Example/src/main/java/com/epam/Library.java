package com.epam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Library {
    @Id
    @Column(name="library_id")
    private int libraryId;
    private String bookName;

    public Library() {
    }

    public Library(int libraryId, String bookName) {
        this.libraryId = libraryId;
        this.bookName = bookName;
    }
}

