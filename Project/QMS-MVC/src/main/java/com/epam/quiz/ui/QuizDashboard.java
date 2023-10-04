package com.epam.quiz.ui;

import com.epam.quiz.utility.cls.ScannerUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class QuizDashboard implements ApplicationContextAware {
    private static final Logger logger = LogManager.getLogger(QuizDashboard.class);
    
    @Autowired
    private QuizOperation quizOperation;

    private ApplicationContext applicationContext;

    public void createQuizBySection() throws Exception {
        logger.info("Choose the following option ");
        logger.info("1) Add the new question ");
        logger.info("2) Remove the question ");
        logger.info("3) Update the question ");
        logger.info("4) To see question list ");
        logger.info("5) Add new section tag ");
        logger.info("6) Update existing section tag ");


        char choice = '0';

        while (Character.getNumericValue(choice) >= 7 || Character.getNumericValue(choice) <= 0) {
            logger.info("Enter the choice");
            choice = ScannerUtil.getConsoleScanner().next().charAt(0);
        }

        quizOperation.perform(Character.getNumericValue(choice));

        AdminLoginPage adminLoginPage = applicationContext.getBean(AdminLoginPage.class);
        adminLoginPage.showAdminPage();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
