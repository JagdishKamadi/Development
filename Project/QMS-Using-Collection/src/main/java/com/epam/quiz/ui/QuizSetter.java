package com.epam.quiz.ui;

import com.epam.quiz.dao.QuizSection;
import com.epam.quiz.model.Question;
import com.epam.quiz.model.QuestionTag;
import com.epam.quiz.utility.cls.ScannerUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;


public class QuizSetter {
    private final static Logger logger = LogManager.getLogger(QuizSetter.class);

    public void showQuestionBySection(QuizSection quizSection)
    {
        showAllQuestion(quizSection);
        showOperationOptionChoice();

        char choice = '0';

        QuestionManipulation questionManipulation = new QuestionManipulationImpl();

        while(quizSection.getAdminQuestionList().size()<5)
        {
            logger.info("Enter the choice");
            choice = ScannerUtil.getConsoleScanner().next().charAt(0);
            
            if(choice=='1')
            {
                questionManipulation.addQuestion(quizSection);
            } else if (choice=='2') {
                questionManipulation.removeQuestion(quizSection);
            } else if (choice=='3') {
                questionManipulation.updateExistingQuestion(quizSection);
            } else if (choice=='4') {
                questionManipulation.addNewQuestionToDB(quizSection);
            }else {
                logger.error("Enter the proper choice");
            }
        }
        logger.info("Quiz set successfully");
        new AdminLoginPage().showAdminPage();
    }

    public void showAllQuestion(QuizSection quizSection)
    {
        Map<Integer, Question> questionMap = quizSection.getSectionQuestion();
        Map<Integer, QuestionTag> questionTagMap = quizSection.getSectionQuestionTag();

        for (int key : questionMap.keySet()) {
            logger.info(key + ") " + questionMap.get(key).getQuestion() + "\t".repeat(4) +
                    "[" + questionTagMap.get(key).getTopicTag() + "|" + questionTagMap.get(key).getDifficultyTag() + "]\n");

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

