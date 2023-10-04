package com.epam.quiz.ui;

import com.epam.quiz.utility.cls.ScannerUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminLoginPage {
    private static final Logger logger = LogManager.getLogger(AdminLoginPage.class);
    @Autowired
    private QuizDashboard quizDashboard;
    @Autowired
    private LoginPage loginPage;

    public void showAdminPage() throws Exception {

        logger.info("\nHello, Admin");
        logger.info("1) Update Quiz");
        logger.info("2) Logout");
        logger.info("Choose option");

        char choice = 0;
        while (choice != '1' && choice != '2') {
            choice = ScannerUtil.getConsoleScanner().next().charAt(0);
        }

        if (choice == '1') {

            quizDashboard.createQuizBySection();
        } else {
            System.exit(0);
        }
    }
}
