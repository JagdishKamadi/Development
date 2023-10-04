package com.epam.quiz.service;

import com.epam.quiz.dao.QuestionOperationDao;
import com.epam.quiz.model.Question;
import com.epam.quiz.utility.cls.RandomNumber;

import java.util.List;
import java.util.Set;

public class CreateQuizService {

    public List<Question> getQuestionNumberListBySectionName(String sectionName)
    {
        QuestionOperationDao questionOperationDao = new QuestionOperationDao();
        List<Question> questionList = questionOperationDao.getCustomQuestionList(generateQuestionListBySectionName(sectionName));

        return  questionList;
    }
    private Set<Integer> generateQuestionListBySectionName(String sectionName)
    {
        sectionName = sectionName.toUpperCase();
        QuestionOperationDao questionOperationDao = new QuestionOperationDao();
        List<Integer> questionNumberList =  questionOperationDao.getQuestionNumberListBySectionName(sectionName);

        return RandomNumber.getQuestionNumberList(questionNumberList);
    }
}
