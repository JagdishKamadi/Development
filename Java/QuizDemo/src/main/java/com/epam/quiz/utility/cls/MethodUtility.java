package com.epam.quiz.utility.cls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MethodUtility {
    private static final Logger logger = LogManager.getLogger(MethodUtility.class);

    public static String acceptOption()
    {
        logger.info("Enter the option ");
        String option = ScannerUtil.getConsoleScanner().next();
        return option;
    }
}
