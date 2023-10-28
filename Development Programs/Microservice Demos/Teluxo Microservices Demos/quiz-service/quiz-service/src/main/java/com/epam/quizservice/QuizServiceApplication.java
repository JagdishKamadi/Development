package com.epam.quizservice;

import com.epam.quizservice.utility.GreetingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizServiceApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(QuizServiceApplication.class, args);
        GreetingService greetingService = context.getBean("greeting", GreetingService.class);
        greetingService.welcomeUser();
    }

}
