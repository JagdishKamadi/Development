package com.epam.quiz.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * after setting all question admin can switch to different page
 * getSwitchPage method help the admin to navigate the pages
 */

@Component
public class PageSwitcher implements ApplicationContextAware {
    private static final Logger logger = LogManager.getLogger(PageSwitcher.class);

    private ApplicationContext applicationContext;

    public void logOutPage() {
        try {
            logger.info("Getting back to home page in few second");
            Thread.sleep(3000);
            LoginPage loginPage = applicationContext.getBean(LoginPage.class);
            loginPage.showLoginPage();

        } catch (Exception e) {
            logger.error(e.getMessage());
            Thread.currentThread().interrupt();
        }

    }

    public void showAdminOrUserPage(final char typeOfUser) throws Exception {
        if (typeOfUser == '1') {
            AdminLoginPage adminLoginPage = applicationContext.getBean(AdminLoginPage.class);
            adminLoginPage.showAdminPage();
        } else {
            UserLoginPage userLoginPage = applicationContext.getBean(UserLoginPage.class);
            userLoginPage.showUserPage();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
