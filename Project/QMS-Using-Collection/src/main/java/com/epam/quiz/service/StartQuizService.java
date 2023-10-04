package com.epam.quiz.service;
import com.epam.quiz.dao.QuizSection;
import com.epam.quiz.model.Question;
import java.io.IOException;
import java.util.*;
import com.epam.quiz.ui.LoginPage;
import com.epam.quiz.ui.UserLoginPage;
import com.epam.quiz.utility.cls.ColorCode;
import com.epam.quiz.utility.cls.MethodUtility;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import org.apache.logging.log4j.*;

public class StartQuizService {
    private static int score=0;
    private static final Logger logger = LogManager.getLogger(StartQuizService.class);
    public void displayQuestionBySection(QuizSection quizSection)
    {
        Map<Integer, Question> questionMap = quizSection.getSectionQuestion();

        int index1=0;
        for(int key : quizSection.getFinalQuestionNumberList())
        {
            logger.info(++index1+") "+questionMap.get(key).getQuestion()+"\t".repeat(4)+
                    "["+quizSection.getSectionQuestionTag().get(key).getTopicTag()+"|"+quizSection.getSectionQuestionTag().get(key).getDifficultyTag()+"]");
            logger.info("A) "+questionMap.get(key).getOption1());
            logger.info("B) "+questionMap.get(key).getOption2());
            logger.info("C) "+questionMap.get(key).getOption3());
            logger.info("D) "+questionMap.get(key).getOption4());


            String optionChoice = MethodUtility.acceptOption();
            boolean result = optionChoice.equalsIgnoreCase(questionMap.get(key).getAnswer());

            showStatusOfGivenAnswer(result,questionMap.get(key).getAnswer());
            score+=getMark(result,quizSection.getSectionQuestionTag().get(key).getDifficultyTag());
        }
        logger.info("Total Score : "+score);

        UserLoginPage userLoginPage = new UserLoginPage();
        userLoginPage.showUserPage();

    }

    private void showStatusOfGivenAnswer(final boolean result,final String correctOption)
    {
        if(result)
        {
            logger.info(ColorCode.getRegularColorCode("Green")+"Correct"+ ColorCode.getResetColorCode());
        }
        else {
            logger.info(ColorCode.getRegularColorCode("red")+"Wrong"+ ColorCode.getResetColorCode());
            logger.info("Correct answer is "+correctOption);
        }
    }

    private int getMark(final boolean result, final QuestionDifficultyTag difficultyTag)
    {
        int inc=0;
        if(result)
        {
            if(difficultyTag==QuestionDifficultyTag.EASY || difficultyTag==QuestionDifficultyTag.MEDIUM)
            {
                inc=1;
            }
            else {
                inc=2;
            }
        }
        return inc;
    }
}
