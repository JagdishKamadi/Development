package com.epam.service;

import com.epam.model.User;
import com.epam.repository.UserRepository;
import com.epam.valueobject.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;
    private Department department;
    @BeforeEach
    void setUp() {
        user = new User();
        user.setFirstName("Jagdish");
        user.setLastName("Kamadi");
        user.setEmailId("jagadishkamadi@gmail.com");
        user.setDepartmentId(1);

        department = Department.builder()
                .departmentName("Computer Science Engineering")
                .departmentAddress("Infront of library")
                .departmentCode("CSE-104")
                .build();
    }

    @Test
    void test_saveUser_success() {
        Mockito.when(userRepository.save(user)).thenReturn(user);
        assertNotNull(userService.saveUser(user));
    }

    @Test
    void test_getUserWithDepartment_success() {
        Mockito.when(userRepository.findById(anyInt())).thenReturn(Optional.ofNullable(user));
        Mockito.when(restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class)).thenReturn(department);
        assertNotNull(userService.getUserWithDepartment(anyInt()));
    }
}