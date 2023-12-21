package com.epam.quiz.service;

import com.epam.quiz.dao.QuestionOperationDao;
import com.epam.quiz.model.Question;

public class QuestionValidationService {

    QuestionOperationDao questionOperationDao;
    public QuestionValidationService()
    {
        questionOperationDao = new QuestionOperationDao();
    }
    public boolean addQuestionChecker(final Question question) {
        int prevSize = getSizeOfQuestionList();
        questionOperationDao.addNewQuestionToDB(question);

        return (prevSize+1)==getSizeOfQuestionList();
    }

    public boolean deleteQuestionChecker(final Integer questionNumber) {
        boolean result = isQuestionPresent(questionNumber);
        if (result) {
            questionOperationDao.deleteQuestionFromDB(questionNumber);
        }
        return result;
    }

    public boolean updateQuestionChecker(final Integer questionNumber, final Question question) {

        boolean result = isQuestionPresent(questionNumber);
        if (result) {
            questionOperationDao.updateQuestionFromDB(questionNumber, question);
        }
        return result;
    }

    private boolean isQuestionPresent(final Integer questionNumber) {
        return questionOperationDao.getAllQuestionList().
                stream().
                anyMatch(qNo -> qNo.getQuestionId() == questionNumber);
    }

    private int getSizeOfQuestionList() {
        return questionOperationDao.getAllQuestionList().size();
    }
}
