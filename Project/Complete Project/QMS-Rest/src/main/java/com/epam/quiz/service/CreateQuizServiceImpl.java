package com.epam.quiz.service;

import com.epam.quiz.model.Question;
import com.epam.quiz.repository.QuestionRepository;
import com.epam.quiz.utility.cls.RandomNumber;
import com.epam.quiz.utility.enm.SectionTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CreateQuizServiceImpl implements CreateQuizService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private QuestionService questionService;

    public List<Question> createQuestionListBySectionName(String sectionName) {

        List<Question> questionList = questionRepository.findBySectionTag(SectionTag.valueOf(sectionName));

        List<Question> newQuestionList = new ArrayList<>();
        Set<Integer> questionNumber = generateQuestionNumberList(sectionName);

        for (Question question : questionList) {
            if (questionNumber.contains(question.getQuestionId())) {
                newQuestionList.add(question);
            }
        }

        return newQuestionList;
    }

    public Set<Integer> generateQuestionNumberList(String sectionName) {

        return RandomNumber
                .getQuestionNumberList(sectionService.getSectionNameNumberList(sectionName));
    }

}
