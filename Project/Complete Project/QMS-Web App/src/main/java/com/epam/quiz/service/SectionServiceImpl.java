package com.epam.quiz.service;

import com.epam.quiz.model.Question;
import com.epam.quiz.repository.QuestionRepository;
import com.epam.quiz.utility.enm.SectionTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Integer> getSectionNameNumberList(String sectionName) {

        List<Question> questionList = questionRepository.findBySectionTag(SectionTag.valueOf(sectionName));
        return questionList.stream().map(Question::getQuestionId).collect(Collectors.toList());
    }
}
