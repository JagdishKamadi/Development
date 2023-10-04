package com.epam.quiz.db;
import com.epam.quiz.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserDataDB {

    public static List<User> userList;
    public static String username="";
    static {
        userList = new ArrayList<>();
        userList.add(new User("Jagdish", "Jagdish@99"));
        userList.add(new User("Madhur", "Madhur@99"));
        userList.add(new User("Jayant", "Jayants@99"));
    }
}
