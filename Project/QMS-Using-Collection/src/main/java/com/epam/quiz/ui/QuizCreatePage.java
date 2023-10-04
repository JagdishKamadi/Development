package com.epam.quiz.ui;

import com.epam.quiz.dao.QuizSection;
import com.epam.quiz.dao.QuizSectionFactory;
import com.epam.quiz.utility.cls.ScannerUtil;
import org.apache.logging.log4j.*;

public class QuizCreatePage {
    private final static Logger logger = LogManager.getLogger(QuizCreatePage.class);
    public void createQuizBySection()
    {
        logger.info("Choose the section to create the quiz");
        logger.info("1) Core Java section");
        logger.info("2) Advance Java section");
        logger.info("3) Java Eight section");

        char choice = '0';

        while(Character.getNumericValue(choice)>=4 || Character.getNumericValue(choice)<=0)
        {
            logger.info("Enter the choice");
            choice = ScannerUtil.getConsoleScanner().next().charAt(0);
        }

        QuizSection quizSection = QuizSectionFactory.getInstance(Character.getNumericValue(choice));
        QuizSetter quizSetter = new QuizSetter();
        quizSetter.showQuestionBySection(quizSection);
    }
}
