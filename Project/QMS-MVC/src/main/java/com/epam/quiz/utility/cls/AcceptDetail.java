package com.epam.quiz.utility.cls;

import com.epam.quiz.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AcceptDetail {
    private static final Logger logger = LogManager.getLogger(AcceptDetail.class);

    private AcceptDetail() {
        throw new IllegalStateException("");
    }

    public static User acceptUserDetail() {

        logger.info("Enter username : ");
        String username = ScannerUtil.getConsoleScanner().next();

        logger.info("Enter mail Id  : ");
        String mailId = ScannerUtil.getConsoleScanner().next();

        logger.info("Enter password : ");
        String password = ScannerUtil.getConsoleScanner().next();

        return new User(username, mailId, password);
    }

    public static User acceptUsernameAndPassword() {
        logger.info("Enter username : ");
        String username = ScannerUtil.getConsoleScanner().next();

        String mailId = "XYZ";

        logger.info("Enter password : ");
        String password = ScannerUtil.getConsoleScanner().next();

        return new User(username, mailId, password);
    }
}
