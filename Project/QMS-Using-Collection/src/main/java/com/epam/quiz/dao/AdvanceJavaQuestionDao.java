package com.epam.quiz.dao;
import com.epam.quiz.db.AdminQuizDB;
import com.epam.quiz.db.AdvanceJavaQuestionDB;
import com.epam.quiz.model.Question;
import com.epam.quiz.model.QuestionTag;
import com.epam.quiz.utility.cls.RandomNumber;
import java.util.List;
import java.util.Map;

public class AdvanceJavaQuestionDao implements QuizSection{

    public Map<Integer, Question> getSectionQuestion()
    {
        return AdvanceJavaQuestionDB.questionAnswerMap;
    }

    public Map<Integer, QuestionTag> getSectionQuestionTag()
    {
        return AdvanceJavaQuestionDB.questionTagMap;
    }



    public List<Integer> getAdminQuestionList()
    {
        return AdvanceJavaQuestionDB.questionNumberListByAdmin;
    }

    public void setAdminQuestionList(int questionNumber)
    {
        AdvanceJavaQuestionDB.questionNumberListByAdmin.add(questionNumber);
    }


    /**
     * this method will give the question number list
     * if admin set the quiz then you will get the admin question list
     * otherwise by default quiz (random quiz) will generate
     * it will return the list of question number
     */
    public List<Integer> getFinalQuestionNumberList()
    {
        return AdvanceJavaQuestionDB.questionNumberListByAdmin.size()>0? AdminQuizDB.advanceJavaQuestionList: RandomNumber.getQuestionNumberList();
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
