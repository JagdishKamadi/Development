package com.epam.quiz.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotNull
    @Size(min = 5, max = 20 ,message = "Username should have 5 or more character")
    private String username;

    @NotNull
    @Size(min=10,message="Mail should contain at least 10 character")
    @Column(name="mail_id")
    private String mailId;

    @Size(min = 5, max = 20 ,message = "Password should have 5 or more character")
    private String password;

    private String role;

    public User() {
    }

    public User(String username, String mailId, String password) {
        this.username = username;
        this.mailId = mailId;
        this.password = password;
    }

    public User(String username, String mailId, String password, String role) {
        this.username = username;
        this.mailId = mailId;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
