package com.epam.quiz.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;




@Entity
public class User {

    @Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", mailId=" + mailId + ", password=" + password
				+ ", typeOfUser=" + typeOfUser + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private int userId;
	
    @NotEmpty
    @Size(min=5,message= "username should have 5 character")
    private String username;
    @Column(name="mail_id")
    
    @NotEmpty
    @Size(min=13,message= "mail id should consist of 13 character")
    private String mailId;
    
    @NotEmpty
    @Size(min=5, max=15, message= "password should contain 5 to 15 character")
    private String password;
    private int typeOfUser;

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
