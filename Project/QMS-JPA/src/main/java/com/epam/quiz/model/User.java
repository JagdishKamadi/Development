package com.epam.quiz.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    private int userId;


    private String username;
    private String password;

    public User() {
    }

    public User(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }



    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
