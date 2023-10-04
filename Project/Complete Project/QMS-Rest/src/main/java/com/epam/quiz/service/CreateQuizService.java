package com.epam.quiz.service;

import java.util.List;
import java.util.Set;

import com.epam.quiz.model.Question;

public interface CreateQuizService {
	List<Question> createQuestionListBySectionName(String sectionName);
	 Set<Integer> generateQuestionNumberList(String sectionName);
}
