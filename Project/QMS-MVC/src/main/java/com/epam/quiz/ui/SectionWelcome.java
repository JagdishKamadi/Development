package com.epam.quiz.ui;

import com.epam.quiz.utility.cls.ColorCode;
import com.epam.quiz.utility.cls.ScannerUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SectionWelcome {

    private char sectionChoice;
    private static final Logger logger = LogManager.getLogger(SectionWelcome.class);
    @Autowired
    private LoginPage loginPage;


    public void sectionWelcomePage() {
        try {
            logger.info("\n{} ********+| Welcome to {} Section |+******** {}\n", ColorCode.getRegularColorCode("blue"), getSectionName(sectionChoice), ColorCode.getResetColorCode());
            logger.info("No of question : 5");
            logger.info("1 question [easy/medium] : 1 mark");
            logger.info("1 question [hard]        : 2 mark");
            logger.info("No negative marking");
            logger.info("Would you like to start quiz now?");

            char choice = '0';
            while (choice != '1' && choice != '2') {
                logger.info("Press 1 to continue : ");
                logger.info("Press 2 to exit test :");
                choice = ScannerUtil.getConsoleScanner().next().charAt(0);
            }


            if (choice == '2') {

                loginPage.showLoginPage();
            }

            logger.info("\n {}  section is going to start within 5 Second,Kindly wait", sectionChoice);
            logger.info("Please do not press any key\n");
            Thread.sleep(5000);
        } catch (IllegalThreadStateException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            logger.error("Unknown Error");
        }
    }

    public String getSectionName(char sectionChoice) {
        if (sectionChoice == '1') {
            return "Core Java";
        }
        return (sectionChoice == '2') ? "Advance Java" : "Java Eight";
    }
}
