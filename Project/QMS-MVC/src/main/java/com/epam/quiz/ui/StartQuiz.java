package com.epam.quiz.ui;

import com.epam.quiz.model.Question;
import com.epam.quiz.service.CreateQuizServiceImpl;
import com.epam.quiz.utility.cls.ColorCode;
import com.epam.quiz.utility.cls.ScannerUtil;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartQuiz {
    private int score = 0;
    private static final Logger logger = LogManager.getLogger(StartQuiz.class);

    @Autowired
    private CreateQuizServiceImpl createQuizServiceImpl;
    @Autowired
    private SectionWelcome sectionWelcome;
    @Autowired
    private UserLoginPage userLoginPage;


    public void displayQuestionBySection(char choice) {


        List<Question> questionList = createQuizServiceImpl.getQuestionNumberListBySectionName(getSectionName(choice));
        int index1 = 0;
        for (Question question : questionList) {
            logger.info("\n{}) {} \t\t\t\t [{}|{}] \n", ++index1, question.getQuestionDescription(), question.getQuestionTag().getQuestionTopicTag(), question.getQuestionTag().getQuestionDifficultyTag());
            logger.info("A) {}", question.getOption1());
            logger.info("B) {}", question.getOption2());
            logger.info("C) {}", question.getOption3());
            logger.info("D) {}", question.getOption4());


            String optionChoice = ScannerUtil.getConsoleScanner().next();
            boolean result = optionChoice.equalsIgnoreCase(question.getAnswer());

            showStatusOfGivenAnswer(result, question.getAnswer());
            score += getMark(result, question.getQuestionTag().getQuestionDifficultyTag());
        }
        logger.info("Total Score : {} ", score);
        score = 0;

        userLoginPage.showUserPage();

    }

    private void showStatusOfGivenAnswer(final boolean result, final String correctOption) {
        if (result) {
            logger.info("{}Correct{}", ColorCode.getRegularColorCode("Green"), ColorCode.getResetColorCode());
        } else {
            logger.info("{}Wrong{}", ColorCode.getRegularColorCode("red"), ColorCode.getResetColorCode());
            logger.info("Correct answer is {}", correctOption);
        }
    }

    private int getMark(final boolean result, final QuestionDifficultyTag difficultyTag) {
        int inc = 0;
        if (result) {
            if (difficultyTag == QuestionDifficultyTag.EASY || difficultyTag == QuestionDifficultyTag.MEDIUM) {
                inc = 1;
            } else {
                inc = 2;
            }
        }
        return inc;
    }

    public String getSectionName(char sectionChoice) {
        if (sectionChoice == '1') {
            return "Core_Java";
        }
        return (sectionChoice == '2') ? "Advance_Java" : "Java_Eight";
    }

}
