package com.epam.quiz.dao;
import com.epam.quiz.model.Question;
import com.epam.quiz.model.QuestionTag;
import java.util.List;
import java.util.Map;

/**
 * common interface for every section
 * each type of section is going to implement this interface
 */
public interface QuizSection {
     Map<Integer, Question>  getSectionQuestion();
     Map<Integer, QuestionTag> getSectionQuestionTag();
     List<Integer> getAdminQuestionList();
     void setAdminQuestionList(int questionNumber);
     List<Integer> getFinalQuestionNumberList();
     void updateQuestionList(Question question,QuestionTag questionTag);
}
