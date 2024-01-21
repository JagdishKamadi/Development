package com.epam.quizservice;

import com.epam.quizservice.utility.GreetingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
public class QuizServiceApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(QuizServiceApplication.class, args);
        GreetingService greetingService = context.getBean("greeting", GreetingService.class);
        greetingService.welcomeUser();
    }

}
