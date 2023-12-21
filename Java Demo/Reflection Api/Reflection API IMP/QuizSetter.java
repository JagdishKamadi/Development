package com.epam.quiz.ui;

import com.epam.quiz.model.Question;
import com.epam.quiz.utility.cls.ScannerUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;


public class QuizSetter {
    private final static Logger logger = LogManager.getLogger(QuizSetter.class);

    public void showQuestionBySection(QuizSection quizSection) throws Exception {
        showAllQuestion(quizSection);
        showOperationOptionChoice();

        char choice = '0';

        QuizManipulation quizManipulation = new QuizManipulationImpl();

        while(quizSection.getAdminQuestionList().size()<5)
        {
            logger.info("Enter the choice");
            choice = ScannerUtil.getConsoleScanner().next().charAt(0);

            QuizOperation.performOperation(Character.getNumericValue(choice),quizSection);
            
//            if(choice=='1')
//            {
//                quizManipulation.addQuestion(quizSection);
//            } else if (choice=='2') {
//                quizManipulation.removeQuestion(quizSection);
//            } else if (choice=='3') {
//                quizManipulation.updateExistingQuestion(quizSection);
//            } else if (choice=='4') {
//                quizManipulation.addNewQuestionToDB(quizSection);
//            }else {
//                logger.error("Enter the proper choice");
//            }
        }
        logger.info("Quiz set successfully");
        new AdminLoginPage().showHomePage();
    }

    public void showAllQuestion(QuizSection quizSection)
    {

        AtomicInteger number = new AtomicInteger();
        for (Question question : quizSection.getAllQuestion()) {
            logger.info(number.incrementAndGet() + ") " +question.getQuestion() + "\t".repeat(4) +
                    "[" + question.getQuestionTag().getQuestionTopicTag() + "|" + question.getQuestionTag().getQuestionDifficultyTag() + "]\n");

        }
    }

    private void showOperationOptionChoice()
    {
        logger.info("Select 5 question out of 10");
        logger.info("1) Add question");
        logger.info("2) Remove question");
        logger.info("3) Update question");
        logger.info("4) Add new question to quiz");
    }
}

