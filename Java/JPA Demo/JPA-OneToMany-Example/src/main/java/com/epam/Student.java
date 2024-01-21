package com.epam;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    private int StudentId;
    private String name;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Library> libraryList;

    public Student() {
    }

    public Student(int studentId, String name, List<Library> libraryList) {
        StudentId = studentId;
        this.name = name;
        this.libraryList = libraryList;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Library> getLibraryList() {
        return libraryList;
    }

    public void setLibraryList(List<Library> libraryList) {
        this.libraryList = libraryList;
    }
}
