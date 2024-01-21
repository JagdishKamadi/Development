package com.epam;

import javax.persistence.*;
import java.security.PrivateKey;

@Entity
public class Student {
    @Id
    @Column(name="student_id")
    private int studentId;
    private String name;

    @OneToOne( cascade = CascadeType.ALL)
    private Library library;

    public Student() {
    }

    public Student(int studentId, String name, Library library) {
        this.studentId = studentId;
        this.name = name;
        this.library = library;
    }
}
