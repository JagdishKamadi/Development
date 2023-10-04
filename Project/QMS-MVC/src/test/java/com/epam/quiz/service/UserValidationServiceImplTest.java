package com.epam.quiz.service;


import com.epam.quiz.dao.UserDao;
import com.epam.quiz.model.User;
import com.epam.quiz.service.UserValidationServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserValidationServiceImplTest {
    @Mock
    UserDao userDaoImpl;
    @InjectMocks
    UserValidationServiceImpl userValidationServiceImpl;
    private List<User> userList;


    @BeforeEach
    void setUpObject() {
        User user1 = new User("Jagdish", "jagadishkamadi@gmail.com", "Jagdish@99", 2);
        User user2 = new User("Aniket", "aniket@gmail.com", "aniket@99", 2);
        User user3 = new User("Admin", "admin@gmail.com", "Admin@00", 1);
        userList = Arrays.asList(user1, user2, user3);
    }

    /**
     * checking for method registerUser
     * TO-DO LIST
     * 1) check valid user
     */

    @Test
    @DisplayName("Checking for valid user")
    void registerUserTest() {
        User user4 = new User("Ranjith", "ranjith@gmail.com", "Ranjith@99", 2);
        when(userDaoImpl.getUserList()).thenReturn(userList);
        assertTrue(userValidationServiceImpl.isValidUserChecker(user4));
        assertFalse(userValidationServiceImpl.isUserExistChecker(user4));
        userDaoImpl.addUserToDb(user4);
        verify(userDaoImpl).addUserToDb(user4);
        verify(userDaoImpl, times(1)).addUserToDb(user4);
    }


    /**
     * checking for method userLogin
     * TO-DO LIST
     * 1) check username and password exist
     * 2) check username exist and password doesn't match
     * 3) check username doesn't match but password match
     * 4) both username and password is different
     */

    @Test
    @DisplayName("Correct username with correct password")
    void isValidUserLoginTest() {
        User user4 = new User("Jagdish", "jagadishkamadi@gmail.com", "Jagdish@99", 2);
        when(userDaoImpl.getUserList()).thenReturn(userList);
        assertTrue(userValidationServiceImpl.userLoginChecker(user4));
    }

    @Test
    @DisplayName("InCorrect username or incorrect password")
    void isValidPasswordLoginTest() {
        User user4 = new User("Jagdish", "jagadishkamadi@gmail.com", "Jagadish@99", 2);
        User user5 = new User("Jagadish", "jagadishkamadi@gmail.com", "Jagdish@99", 2);
        User user6 = new User("Jagadish", "jagadishkamadi@gmail.com", "Jagadish@99", 2);
        when(userDaoImpl.getUserList()).thenReturn(userList);
        Assertions.assertAll(() -> assertFalse(userValidationServiceImpl.userLoginChecker(user4)),
                () -> assertFalse(userValidationServiceImpl.userLoginChecker(user5)),
                () -> assertFalse(userValidationServiceImpl.userLoginChecker(user6)));
    }

    /**
     * checking for method isUserExist
     * TO-DO LIST
     * 1) check username and mail exist
     * 2) check username exist and mail doesn't exist
     * 3) check username doesn't exist but mail exist
     * 4) both username and mail is different
     */

    @Test
    @DisplayName("Checking for exist username or exist mail id")
    void isUsernameAndMailExistTest() {

        User user4 = new User("Jagdish", "jagadishkamadi@gmail.com", "Jagdish@99");
        User user5 = new User("Jagdish", "jagdishkamadi@gmail.com", "Jagdish@99");
        User user6 = new User("Jagadish", "jagadishkamadi@gmail.com", "Jagdish@99");

        when(userDaoImpl.getUserList()).thenReturn(userList);
        Assertions.assertAll(() -> assertTrue(userValidationServiceImpl.isUserExistChecker(user4)),
                () -> assertTrue(userValidationServiceImpl.isUserExistChecker(user5)),
                () -> assertTrue(userValidationServiceImpl.isUserExistChecker(user6)));

    }

    @Test
    @DisplayName("Checking with different username and different mail id")
    void differentUsernameAndMailId() {
        User user4 = new User("Kunal", "kunal@gmail.com", "Kunal@99");
        when(userDaoImpl.getUserList()).thenReturn(userList);
        assertFalse(userValidationServiceImpl.isUserExistChecker(user4));
    }

    /**
     * checking for method isValidUser
     * TO-DO LIST
     * 1) check length of username, mailId and password
     */

    @Test
    @DisplayName("Checking for valid length of user")
    void isValidUserLengthTest() {
        User user4 = new User("Tejas", "tejas@gmail.com", "Tejas@99");
        assertTrue(userValidationServiceImpl.isValidUserChecker(user4));
    }

    @Test
    @DisplayName("Rejection for invalid length of username ")
    void isInValidUsernameLengthTest() {
        User user4 = new User("Teja", "tejas@gmail.com", "Tejas@99");
        assertFalse(userValidationServiceImpl.isValidUserChecker(user4));
    }

    @Test
    @DisplayName("Rejection for invalid length of mail ")
    void isInValidMailIdLengthTest() {
        User user4 = new User("Tejas", "tj@gmail.com", "Tejas@99");
        assertFalse(userValidationServiceImpl.isValidUserChecker(user4));
    }

    @Test
    @DisplayName("Rejection for invalid length of password ")
    void isInValidPasswordLengthTest() {
        User user4 = new User("Tejas", "tejas@gmail.com", "T@99");
        assertFalse(userValidationServiceImpl.isValidUserChecker(user4));
    }


}
