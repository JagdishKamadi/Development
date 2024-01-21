package com.epam;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @Column(name = "student_id")
    private int studentId;
    private String name;

    // this mean we don't need to save other entity manually
    @OneToMany(targetEntity = Library.class,cascade = CascadeType.ALL)
    private List<Library> libraryList ;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
