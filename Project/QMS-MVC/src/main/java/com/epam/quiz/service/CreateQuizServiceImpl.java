package com.epam.quiz.service;

import com.epam.quiz.dao.QuestionDao;
import com.epam.quiz.model.Question;
import com.epam.quiz.utility.cls.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class CreateQuizServiceImpl implements CreateQuizService {

    @Autowired
    private QuestionDao questionDaoImpl;

    @Override
    public List<Question> getQuestionNumberListBySectionName(String sectionName) {
        return questionDaoImpl.getCustomQuestionList(generateQuestionListBySectionName(sectionName));
    }

    public List<Question> getQuestionListById(Set<Integer> lst)
    {
    	return questionDaoImpl.getCustomQuestionList(lst);
    }
    
    @Override
    public Set<Integer> generateQuestionListBySectionName(String sectionName) {
        sectionName = sectionName.toUpperCase();
        List<Integer> questionNumberList = questionDaoImpl.getQuestionNumberListBySectionName(sectionName);

        return RandomNumber.getQuestionNumberList(questionNumberList);
    }
    
    public List<Question> getAllQuestionList()
    {
    	return questionDaoImpl.getAllQuestionList();
    }
}
