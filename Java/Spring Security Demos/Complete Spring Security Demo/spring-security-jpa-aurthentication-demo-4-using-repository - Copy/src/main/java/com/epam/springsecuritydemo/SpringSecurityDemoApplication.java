package com.epam.springsecuritydemo;

import com.epam.springsecuritydemo.entity.User;
import com.epam.springsecuritydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringSecurityDemoApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = User.builder()
                .username("Jagdish")
                .password("Jagdish@99")
                .role("ROLE_ADMIN")
                .build();

        User user2 = User.builder()
                .username("Madhur")
                .password("Madhur@99")
                .role("ROLE_USER")
                .build();

        userRepository.saveAll(List.of(user1,user2));
    }
}
