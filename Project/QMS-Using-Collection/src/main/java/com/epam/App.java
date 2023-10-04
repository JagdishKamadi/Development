package com.epam;
import com.epam.quiz.ui.LoginPage;
import org.apache.logging.log4j.*;
import com.epam.quiz.utility.cls.ColorCode;
import java.io.IOException;


public class App 
{
    private static final Logger logger = LogManager.getLogger(App.class);
    public static void main( String[] args ) throws IOException {

        logger.error(ColorCode.getRegularColorCode("cyan") +"********+| Welcome to Quiz Management System |+********"+ColorCode.getResetColorCode());

        // start quiz from here
        LoginPage loginPage = new LoginPage();
        loginPage.showLoginPage();

//        logger.debug("debug");
//        logger.info("info");
//        logger.warn("warn");
//        logger.error("error");

    }
}
