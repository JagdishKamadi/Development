package com.epam;

import com.epam.model.User;
import com.epam.model.UserInformation;
import com.epam.repository.UserRepository;
import com.epam.ui.GreetingClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UserServiceDemoWithAllTypeTestingApplication implements CommandLineRunner {

    @Autowired
    public UserRepository userRepository;

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(UserServiceDemoWithAllTypeTestingApplication.class, args);
        GreetingClass greetingClass = context.getBean(GreetingClass.class);
        greetingClass.sayHelloToUser("Jagdish");
    }

    @Override
    public void run(String... args) throws Exception {
        UserInformation userInformation = new UserInformation();
        userInformation.setEmail("jagadishkamadi@gmail.com");
        userInformation.setPhoneNumber("7745824763");
        userInformation.setDateOfBirth("01012000");

        User user = User.builder()
                .username("JagdishKamadi")
                .password("Jagdish@99")
                .userInformation(userInformation)
                .build();

        /*userRepository.save(user);*/
    }
}
