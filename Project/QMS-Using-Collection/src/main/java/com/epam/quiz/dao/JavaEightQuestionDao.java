package com.epam.quiz.dao;
import com.epam.quiz.db.AdminQuizDB;
import com.epam.quiz.db.JavaEightQuestionDB;
import com.epam.quiz.model.Question;
import com.epam.quiz.model.QuestionTag;
import com.epam.quiz.utility.cls.RandomNumber;

import java.util.List;
import java.util.Map;

public class JavaEightQuestionDao implements QuizSection{
    public Map<Integer, Question> getSectionQuestion()
    {
        return JavaEightQuestionDB.questionAnswerMap;
    }
    public Map<Integer, QuestionTag> getSectionQuestionTag()
    {
        return JavaEightQuestionDB.questionTagMap;
    }


    public List<Integer> getAdminQuestionList()
    {
        return JavaEightQuestionDB.questionNumberListByAdmin;
    }

    public void setAdminQuestionList(int questionNumber)
    {
        JavaEightQuestionDB.questionNumberListByAdmin.add(questionNumber);
    }

    /**
     * this method will give the question number list
     * if admin set the quiz then you will get the admin question list
     * otherwise by default quiz (random quiz) will generate
     * it will return the list of question number
     */
    public List<Integer> getFinalQuestionNumberList()
    {
        return JavaEightQuestionDB.questionNumberListByAdmin.size()>0 ? AdminQuizDB.JavaEightQuestionList : RandomNumber.getQuestionNumberList();
    }

    @Override
    public void updateQuestionList(Question question, QuestionTag questionTag) {
        Map<Integer,Question> questionMap = getSectionQuestion();
        Map<Integer,QuestionTag> questionTagMap = getSectionQuestionTag();
        int size = questionMap.size()+1;
        // now update the thing
        getSectionQuestion().put(size,question);
        getSectionQuestionTag().put(size,questionTag);
    }

}
