package com.epam.quiz.ui;
import com.epam.quiz.service.LoginService;
import com.epam.quiz.utility.cls.ScannerUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class AcceptDetail {
    private static final Logger logger = LogManager.getLogger(LoginService.class);

    public static List<String> getUsernameAndPasswordDetail(){

        List<String> listOfDetails = new ArrayList<>();

        logger.info("Enter username : ");
        listOfDetails.add(ScannerUtil.getConsoleScanner().next());

        logger.info("Enter password : ");
        listOfDetails.add(ScannerUtil.getConsoleScanner().next());

        return listOfDetails;
    }
}