package com.epam.quiz.dao;


import com.epam.quiz.db.AdminQuizDB;
import com.epam.quiz.db.AdvanceJavaQuestionDB;
import com.epam.quiz.db.JavaEightQuestionDB;
import com.epam.quiz.model.Question;
import com.epam.quiz.utility.cls.MySQLConnection;
import com.epam.quiz.utility.cls.RandomNumber;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class JavaEightQuestionDao implements QuizSection {
    public List<Question> getAllQuestion() {

        EntityManager manager = MySQLConnection.getConnection();

        Query query = manager.createQuery("select q from Question q");
        List<Question> questionList = query.getResultList();

        manager.getTransaction().commit();
        manager.close();

        return questionList;
    }

    public void addNewQuestionToDB(Question question) {
        EntityManager manager = MySQLConnection.getConnection();

        Query q = manager.createQuery("Select MAX(q.questionId) from Question q");
        Integer count = (int) q.getSingleResult();
        question.setQuestionId(count + 1);

        manager.persist(question);

        manager.getTransaction().commit();
        manager.close();
    }

    public List<Question> getCustomQuestionList(List<Integer> list) {

        EntityManager manager = MySQLConnection.getConnection();
        List<Question> questionList = new ArrayList<>();

        for (int i : list) {

            questionList.add(manager.find(Question.class, i));
        }

        manager.getTransaction().commit();
        manager.close();

        return questionList;
    }

    @Transactional
    public void deleteAllQuestion() {
        EntityManager manager = MySQLConnection.getConnection();
        manager.createQuery("delete from Question").executeUpdate();
        manager.createQuery("delete from QuestionTag").executeUpdate();

        manager.getTransaction().commit();
        manager.close();

    }

    public List<Integer> getAdminQuestionList() {
        return JavaEightQuestionDB.questionNumberListByAdmin;
    }

    public void setAdminQuestionList(int questionNumber) {
        JavaEightQuestionDB.questionNumberListByAdmin.add(questionNumber);
    }

    /**
     * this method will give the question number list
     * if admin set the quiz then you will get the admin question list
     * otherwise by default quiz (random quiz) will generate
     * it will return the list of question number
     */
    public List<Integer> getFinalQuestionNumberList() {
        return JavaEightQuestionDB.questionNumberListByAdmin.size() > 0 ? AdminQuizDB.JavaEightQuestionList : RandomNumber.getQuestionNumberList();
    }

    public void setAllQuestion() {
        JavaEightQuestionDB javaEightQuestionDB = new JavaEightQuestionDB();
        javaEightQuestionDB.addQuestionToDB();
    }
}
