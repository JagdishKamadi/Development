package com.epam.one_to_one;

import javax.persistence.*;

@Entity
public class Library {
    @Id
    private int id;
    private String bookName;

    @OneToOne
    private Student student;

    public Library() {
    }

    public Library(int id, String bookName, Student student) {
        this.id = id;
        this.bookName = bookName;
        this.student = student;
    }

}
