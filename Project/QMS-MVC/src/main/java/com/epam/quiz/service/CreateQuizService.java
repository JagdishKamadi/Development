package com.epam.quiz.service;

import com.epam.quiz.model.Question;

import java.util.List;
import java.util.Set;

public interface CreateQuizService {
    List<Question> getQuestionNumberListBySectionName(String sectionName);
    Set<Integer> generateQuestionListBySectionName(String sectionName);
  List<Question> getQuestionListById(Set<Integer> lst);
   List<Question> getAllQuestionList();
}
