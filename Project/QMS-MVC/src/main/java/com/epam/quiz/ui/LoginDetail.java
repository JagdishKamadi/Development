package com.epam.quiz.ui;

import com.epam.quiz.exception.UserNotFoundException;
import com.epam.quiz.model.User;
import com.epam.quiz.service.UserValidationServiceImpl;
import com.epam.quiz.utility.cls.AcceptDetail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LoginDetail implements ApplicationContextAware {
    private static final Logger logger = LogManager.getLogger(LoginDetail.class);
    @Autowired
    private UserValidationServiceImpl userValidationServiceImpl;

    ApplicationContext applicationContext;


    public void acceptLoginDetails(char typeOfUser) {
        boolean flag = false;
        String username = "";

        while (!flag) {
            User user = AcceptDetail.acceptUsernameAndPassword();
            if (typeOfUser == '1') {
                // for admin
                user.setTypeOfUser(1);
                flag = userValidationServiceImpl.userLoginChecker(user);
            } else {
                // for user
                user.setTypeOfUser(2);
                flag = userValidationServiceImpl.userLoginChecker(user);
            }

            try {
                if (!flag) {
                    throw new UserNotFoundException("Username or Password wrong!");
                }
            } catch (UserNotFoundException e) {
                logger.error(e.getMessage());
            }

            username = user.getUsername();
        }

        logger.info("Login successfully");
        logger.info("Welcome ");
        logger.info(username);
    }


    public void registerDetails() {
        User user = AcceptDetail.acceptUserDetail();

        boolean result = userValidationServiceImpl.registerUserChecker(user);

        if (result) {
            logger.info("Registered successfully");
        } else {
            logger.error("user or mail id already exist! or Enter the valid details");

        }

        try {
            LoginPage loginPage = applicationContext.getBean(LoginPage.class);
            loginPage.showLoginPage();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
