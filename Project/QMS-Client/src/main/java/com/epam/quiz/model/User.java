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
    private int typeOfUser;
    
    
    @Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", mailId=" + mailId + ", password=" + password
				+ ", typeOfUser=" + typeOfUser + "]";
	}


    public User() {
    }

    public User(String username, String mailId, String password) {
        this.username = username;
        this.mailId = mailId;
        this.password = password;
    }

    public User(String username, String mailId, String password, int typeOfUser) {
        this.username = username;
        this.mailId = mailId;
        this.password = password;
        this.typeOfUser = typeOfUser;
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

    public int getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(int typeOfUser) {
        this.typeOfUser = typeOfUser;
    }
}
