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
    private  int score=0;
    private static final Logger logger = LogManager.getLogger(StartQuizService.class);
    public void displayQuestionBySection(QuizSection quizSection)
    {
        List<Question> questionList = quizSection.getCustomQuestionList(quizSection.getFinalQuestionNumberList());

        int index1=0;
        for(Question question : questionList)
        {
            logger.info(++index1+") "+question.getQuestion()+"\t".repeat(4)+
                    "["+question.getQuestionTag().getQuestionTopicTag()+"|"+question.getQuestionTag().getQuestionDifficultyTag()+"]");
            logger.info("A) "+question.getOption1());
            logger.info("B) "+question.getOption2());
            logger.info("C) "+question.getOption3());
            logger.info("D) "+question.getOption4());


            String optionChoice = MethodUtility.acceptOption();
            boolean result = optionChoice.equalsIgnoreCase(question.getAnswer());

            showStatusOfGivenAnswer(result,question.getAnswer());
            score+=getMark(result,question.getQuestionTag().getQuestionDifficultyTag());
        }
        logger.info("Total Score : "+score);
        score=0;

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
