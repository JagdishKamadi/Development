package com.epam.service;

import com.epam.model.Question;

import java.util.Optional;

public interface QuestionService {
    void addQuestion(Question question);
    public Optional<Question> getQuestion(final Integer questionId);
}
