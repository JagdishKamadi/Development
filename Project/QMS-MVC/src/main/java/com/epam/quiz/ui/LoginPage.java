package com.epam.quiz.ui;

import com.epam.quiz.service.UserValidationServiceImpl;
import com.epam.quiz.utility.cls.ScannerUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * actual login UI start from this class
 * this is first page
 * from this page user and admin navigate to different page
 */

@Component
public class LoginPage {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    @Autowired
    private LoginDetail loginDetail;
    @Autowired
    private PageSwitcher pageSwitcher;

    @Autowired
    private UserValidationServiceImpl userValidationServiceImpl;

    public void showLoginPage() throws Exception {
        char typeOfUser = '0';

        while (Character.getNumericValue(typeOfUser) >= 4 || Character.getNumericValue(typeOfUser) <= 0) {
            logger.info("\n");
            logger.info("\t\t\t\tLogin As");
            logger.info("\t1) Admin");
            logger.info("\t2) User");
            logger.info("\t" + "3) Register");


            logger.info("\nPlease enter option : ");
            typeOfUser = ScannerUtil.getConsoleScanner().next().charAt(0);


            if (typeOfUser == '3') {
                loginDetail.registerDetails();
            } else {
                loginDetail.acceptLoginDetails(typeOfUser);
                pageSwitcher.showAdminOrUserPage(typeOfUser);
            }
        }
    }


}
