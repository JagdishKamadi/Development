package com.epam.quiz.ui;

public interface QuizManipulation {
    void addQuestion(QuizSection quizSection);
    void removeQuestion(QuizSection quizSection);
    void updateExistingQuestion(QuizSection quizSection);
    void addNewQuestionToDB(QuizSection quizSection);

}
