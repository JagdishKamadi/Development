package com.epam;

import javax.persistence.*;

@Entity
public class Library {
    @Id
    @Column(name = "library_id")
    private int lId;
    private String bookName;

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
