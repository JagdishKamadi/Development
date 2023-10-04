package com.epam.quiz.service;

import com.epam.quiz.dao.QuestionDaoImpl;
import com.epam.quiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionValidationServiceImpl implements QuestionValidationService {

    @Autowired
    private QuestionDaoImpl questionDaoImpl;

    public boolean addQuestionChecker(final Question question) {

        int prevSize = getSizeOfQuestionList();
        questionDaoImpl.addNewQuestionToDB(question);

        return (prevSize + 1) == getSizeOfQuestionList();
    }

    public boolean deleteQuestionChecker(final Integer questionNumber) {

        boolean result = isQuestionNumberPresentChecker(questionNumber);
        if (result) {
            questionDaoImpl.deleteQuestionFromDB(questionNumber);
        }
        return result;
    }

    @Override
    public boolean updateQuestionChecker(final Integer questionNumber, final Question question) {
        boolean result = isQuestionNumberPresentChecker(questionNumber);
        if (result) {
            questionDaoImpl.updateQuestionFromDB(questionNumber, question);
        }
        return result;
    }
    
    public Question getQuestionById(Integer questionId)
    {
    	return questionDaoImpl.getQuestionById(questionId);
    }
    
    public int getCountBySectionName(String sectionName)
    {
    	return questionDaoImpl.getCountBySectionName(sectionName);
    }

    @Override
    public List<Question> getQuestionList() {
        return questionDaoImpl.getAllQuestionList();
    }

    public boolean isQuestionNumberPresentChecker(final Integer questionNumber) {
        return questionDaoImpl.getAllQuestionList().stream().anyMatch(qNo -> qNo.getQuestionId() == questionNumber);
    }

    private int getSizeOfQuestionList() {
        return questionDaoImpl.getAllQuestionList().size();
    }
}
