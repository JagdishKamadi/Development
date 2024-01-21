package com.epam;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Library {
    @Id
    private int lId;
    private String bookName;

    public Library() {
    }

    public Library(int lId, String bookName) {
        this.lId = lId;
        this.bookName = bookName;
    }

}
