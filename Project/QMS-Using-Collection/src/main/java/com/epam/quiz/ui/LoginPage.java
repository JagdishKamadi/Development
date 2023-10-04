package com.epam.quiz.ui;
import com.epam.quiz.service.LoginService;
import com.epam.quiz.service.PageSwitcherService;
import com.epam.quiz.utility.cls.ScannerUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

/**
 * actual login UI start from this class
 * this is first page
 * from this page user and admin navigate to different page
 */
public class LoginPage {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    public void showLoginPage() throws IOException {

        logger.info("\n"+"\t".repeat(4)+"Login As");
        logger.info("\t1) Admin");
        logger.info("\t2) User");
        logger.info("\t"+"3) Register");

        char typeOfUser = '0';

        while(Character.getNumericValue(typeOfUser)>=4 || Character.getNumericValue(typeOfUser)<=0)
        {
            logger.info("\nPlease enter option : ");
            typeOfUser = ScannerUtil.getConsoleScanner().next().charAt(0);
        }

        LoginService loginService = new LoginService();
        if(typeOfUser=='3')
        {
            loginService.register();
        }
        else
        {
            loginService.acceptLoginDetails(typeOfUser);
            PageSwitcherService pageSwitcherService = new PageSwitcherService();
            pageSwitcherService.showAdminOrUserPage(typeOfUser);
        }

    }
}
