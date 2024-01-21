package com.epam.service;

import com.epam.exception.UserNotFoundException;
import com.epam.model.User;
import com.epam.model.UserInformation;
import com.epam.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.powermock.reflect.Whitebox;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
// @RunWith for Junit4
//@RunWith(JUnitParamsRunner.class)
public class UserServiceTest {

    private static final Logger LOGGER = LogManager.getLogger(UserServiceTest.class);

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;
    private User user;
    private UserInformation userInformation;

    @BeforeEach
    void setUp() {
        userInformation = UserInformation.builder()
                .email("jagdishkamadi@gmail.com")
                .phoneNumber("7745824763")
                .dateOfBirth("01-01-2000")
                .build();

        user = User.builder()
                .username("JagdishKamadi")
                .password("Jagdish@99")
                .build();
    }

    @Test
    void test_getUser_If_User_Exist() {
        when(userRepository.findByUsername(any(String.class))).thenReturn(Optional.of(user));
        assertNotNull(userServiceImpl.getUser(anyString()));
    }

    @Test
    public void test_getUser_If_User_Not_Exist_Using_When() {
        when(userRepository.findByUsername(anyString())).thenThrow(new UserNotFoundException());
        assertThrows(UserNotFoundException.class, () -> userServiceImpl.getUser(anyString()));
    }

    @Test
    public void test_getUser_If_User_Not_Exist_Using_DoThrow() {
        doThrow(UserNotFoundException.class).when(userRepository).findByUsername(anyString());
        assertThrows(UserNotFoundException.class, () -> userServiceImpl.getUser(anyString()));
    }

    @Test
    public void test_getUser_If_User_Not_Exist_By_Using_Mockito() {
        given(userRepository.findByUsername(any(String.class))).willThrow(new UserNotFoundException());
        assertThrows(UserNotFoundException.class, () -> userServiceImpl.getUser(anyString()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Jagdish", "Madhur", "Tejas"})
    public void test_getUser_If_User_Is_Multiple(String username) {
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));
        assertNotNull(userServiceImpl.getUser(username));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Jagdish", "Madhur", "Tejas"})
    public void test_getUser_If_User_Is_Multiple_Throws_Exception(String username) {
        when(userRepository.findByUsername(username)).thenThrow(new UserNotFoundException());
        assertThrows(UserNotFoundException.class, () -> userServiceImpl.getUser(username));
    }

    @Test
    void test_getUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        assertNotNull(userServiceImpl.getUsers());
        assertEquals(1, userServiceImpl.getUsers().size());
    }

    /**
     * below two method has some problems
     * fixing is going on
     * but need to understand why it is not working
     *
     * @throws Exception
     */
    @Test
    void test_save_Using_Reflection_API() throws Exception {
        Class cl = Class.forName("com.epam.service.UserServiceImpl");
        UserServiceImpl userService = (UserServiceImpl) cl.newInstance();
        Method method = cl.getDeclaredMethod("isUserExist", String.class);
        method.setAccessible(true);
        OngoingStubbing<Object> isUserExist = when(method.invoke(userService, any(String.class))).thenReturn(Boolean.TRUE);
        System.out.println(isUserExist);
    }

    @Test
    void test_save_Using_PowerMock() throws Exception {
        boolean result = Whitebox.invokeMethod(userServiceImpl, "isUserExist", "Jagdish");
        System.out.println(result);
    }

    @Test
    void test_delete_If_User_Exist() {

    }
}