package com.epam.quiz.ui;
import com.epam.quiz.utility.cls.ScannerUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

public class AdminLoginPage {
    private final static Logger logger = LogManager.getLogger(AdminLoginPage.class);

    public  void showAdminPage()
    {
        logger.info("\nHello, Admin");
        logger.info("1) Create quiz");
        logger.info("2) Logout");
        logger.info("Choose option");

        char choice = 0;
        while(choice!='1' && choice!='2')
        {
            choice = ScannerUtil.getConsoleScanner().next().charAt(0);
        }

        if(choice=='1')
        {
            QuizCreatePage quizCreatePage = new QuizCreatePage();
            quizCreatePage.createQuizBySection();
        }
        else {
            try {
                System.out.println("Getting back to home page");
                Thread.sleep(3000);
                LoginPage loginPage = new LoginPage();
                loginPage.showLoginPage();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
