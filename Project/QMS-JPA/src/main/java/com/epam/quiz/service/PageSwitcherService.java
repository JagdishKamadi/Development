package com.epam.quiz.service;
import com.epam.quiz.ui.AdminLoginPage;
import com.epam.quiz.ui.LoginPage;
import com.epam.quiz.ui.UserLoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * after setting all question admin can switch to different page
 * getSwitchPage method help the admin to navigate the pages
 */
public class PageSwitcherService {
    private static final Logger logger = LogManager.getLogger(PageSwitcherService.class);

    public void getLogOut()
    {
        try {
            logger.info("Getting back to home page");
            Thread.sleep(3000);

            LoginPage loginPage = new LoginPage();
            loginPage.showLoginPage();


        } catch (InterruptedException |IOException  e) {
            logger.error(e.getMessage());
        }

    }

    public void showAdminOrUserPage(final char typeOfUser)
    {
        if(typeOfUser=='1')
        {
            AdminLoginPage adminLoginPage = new AdminLoginPage();
            adminLoginPage.showAdminPage();
        }
        else {
            new UserLoginPage().showUserPage();
        }
    }
}
