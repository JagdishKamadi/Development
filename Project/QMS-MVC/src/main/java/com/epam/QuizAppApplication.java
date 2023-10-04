package com.epam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.epam.quiz.ui.LoginPage;
import com.epam.quiz.utility.cls.ColorCode;

@SpringBootApplication
public class QuizAppApplication {
    private static final Logger logger = LogManager.getLogger(QuizAppApplication.class);

    public static void main(String[] args) throws Exception {

        logger.info("{}********+| Welcome to Quiz Management System |+********{}",
                ColorCode.getRegularColorCode("cyan"), ColorCode.getResetColorCode());

        ApplicationContext context = SpringApplication.run(QuizAppApplication.class, args);

        LoginPage loginPage = context.getBean(LoginPage.class);
        loginPage.showLoginPage();

    }

}
