package com.epam.quiz.ui;
import com.epam.quiz.dao.QuizSection;

public interface QuestionManipulation {
    void addQuestion(QuizSection quizSection);
    void removeQuestion(QuizSection quizSection);
    void updateExistingQuestion(QuizSection quizSection);
    void addNewQuestionToDB(QuizSection quizSection);

}
