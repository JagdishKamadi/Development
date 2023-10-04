package com.epam.service;

import com.epam.dao.QuestionDao;
import com.epam.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public QuestionServiceImpl()
    {

    }
    public void addQuestion(Question question)
    {
        questionDao.save(question);
    }

    public Optional<Question> getQuestion(final Integer questionId)
    {

        return questionDao.findById(questionId);
    }
}
