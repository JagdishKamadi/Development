package com.epam.quiz.dao;
import com.epam.quiz.db.UserDataDB;
import com.epam.quiz.model.User;

public class UserCredentialDao {

    public  boolean isUserLogin(final String username,final String password)
    {
        return UserDataDB.userList.stream().anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));
    }

    public boolean registerUser(final String username, final String password)
    {
        boolean isUserExist = UserDataDB.userList.
                stream().
                anyMatch(user->user.getUsername().equals(username));

        if(!isUserExist)
            UserDataDB.userList.add(new User(username,password));

        return isUserExist;
    }

    public void setUserName(String userName){
        UserDataDB.username = userName;
    }

    public String getUserName()
    {
        return UserDataDB.username;
    }
}
