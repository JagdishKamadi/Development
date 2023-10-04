package com.epam.quiz.ui;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class QuizOperation implements InitializingBean {

    Map<Integer, Operation> map = new HashMap<>();
    @Autowired
    QuizManipulation quizManipulation;

    public void perform(int choice) {
        map.get(choice).ran();
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        map.put(1, quizManipulation::addQuestion);
        map.put(2, quizManipulation::removeQuestion);
        map.put(3, quizManipulation::updateQuestion);
        map.put(4, quizManipulation::showQuestion);
        map.put(5, quizManipulation::addNewSectionTag);
        map.put(6, quizManipulation::updateExistingSectionTag);
    }
}