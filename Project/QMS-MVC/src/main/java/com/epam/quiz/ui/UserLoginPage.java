package com.epam.quiz.ui;

import com.epam.quiz.service.SectionValidationServiceImpl;
import com.epam.quiz.utility.cls.ScannerUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.TreeMap;

@Component
public class UserLoginPage implements ApplicationContextAware {
    private static final Logger logger = LogManager.getLogger(UserLoginPage.class);

    @Autowired
    private PageSwitcher pageSwitcher;
    @Autowired
    private SectionWelcome sectionWelcome;

    @Autowired
    private SectionValidationServiceImpl sectionValidationService;
    private ApplicationContext applicationContext;

    public void showUserPage() {
        logger.info("Welcome to Quiz Management System\n");
        logger.info("-------+ Choose the section to take the quiz +-------");

        TreeMap<Integer, String> sectionMap = new TreeMap<>(sectionValidationService.getSectionList());

        sectionMap.keySet()
                .stream()
                .forEach(element -> logger.info("{}) {}", element, sectionMap.get(element)));

        logger.info("{}) Log out ", sectionMap.lastKey() + 1);

        char choice = '0';

        while (Character.getNumericValue(choice) >= (sectionMap.lastKey()+1)  || Character.getNumericValue(choice) <= 0) {
            logger.info("Enter choice : ");
            choice = ScannerUtil.getConsoleScanner().next().charAt(0);
        }

        if (choice == Character.forDigit(sectionMap.lastKey() + 1, 10)) {
            pageSwitcher.logOutPage();
        }
        sectionWelcome.sectionWelcomePage();

        StartQuiz startQuiz = applicationContext.getBean(StartQuiz.class);
        startQuiz.displayQuestionBySection(choice);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
