package com.epam.quiz.dao;

import com.epam.quiz.db.QuestionListDB;
import com.epam.quiz.model.Question;
import com.epam.quiz.utility.cls.MySQLConnection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class QuestionOperationDao {

    // get the all question list
    public  List<Question> getAllQuestionList() {
        EntityManager manager = MySQLConnection.getConnection();
        manager.clear();

        Query query = manager.createQuery("Select q from Question q");
        List<Question> questionList = query.getResultList();
        manager.close();

        return  questionList;
    }

    //  Add  question
    public void addNewQuestionToDB(final Question question) {
        Integer tableSize = QuestionListDB.getSizeOfQuestionList();
        question.getQuestionTag().setQuestionTagId(tableSize + 1);

        EntityManager manager = MySQLConnection.getConnection();
        manager.clear();
        manager.getTransaction().begin();

        manager.persist(question);

        manager.getTransaction().commit();
        manager.close();
    }

    //  Remove  question
    public void deleteQuestionFromDB(final Integer questionNumber) {
        Integer questionTagId;
        EntityManager manager = MySQLConnection.getConnection();

        manager.clear();
        manager.getTransaction().begin();

        Question tempQuestion = manager.find(Question.class, questionNumber);
        questionTagId = tempQuestion.getQuestionTag().getQuestionTagId();

        Query query = manager.createNativeQuery("DELETE FROM Question WHERE questionId = " + questionNumber);
        query.executeUpdate();

        query = manager.createNativeQuery("DELETE FROM QuestionTag WHERE questionTagId = " + questionTagId);
        query.executeUpdate();

        manager.getTransaction().commit();
        manager.close();
    }

    //  update question
    public void updateQuestionFromDB(final Integer id, Question question) {
        Integer questionTagId;
        EntityManager manager = MySQLConnection.getConnection();
        manager.clear();
        manager.getTransaction().begin();

        Question tempQuestion = manager.find(Question.class, id);
        questionTagId = tempQuestion.getQuestionTag().getQuestionTagId();

        Query query = manager.createQuery("UPDATE Question SET question = :que, option1 = :op1, option2 = :op2, option3 = :op3, option4 = :op4, answer =  :ans, sectionName = :sName WHERE questionId = :id");
        query.setParameter("id", id);
        query.setParameter("que", question.getQuestion());
        query.setParameter("op1", question.getOption1());
        query.setParameter("op2", question.getOption1());
        query.setParameter("op3", question.getOption1());
        query.setParameter("op4", question.getOption1());
        query.setParameter("ans", question.getAnswer());
        query.setParameter("sName", question.getSectionName());
        query.executeUpdate();

        query = manager.createQuery("UPDATE QuestionTag SET questionDifficultyTag = :difficultyTag, questionTopicTag = :topicTag WHERE questionTagId = :id");
        query.setParameter("id", questionTagId);
        query.setParameter("difficultyTag", question.getQuestionTag().getQuestionDifficultyTag());
        query.setParameter("topicTag", question.getQuestionTag().getQuestionTopicTag());
        query.executeUpdate();

        manager.getTransaction().commit();
        manager.close();
    }


    //  Get custom question list
    public List<Question> getCustomQuestionList(Set<Integer> questionList) {
        EntityManager manager = MySQLConnection.getConnection();
        List<Question> newQuestionList = new ArrayList<>();

        for (Integer i : questionList) {
            newQuestionList.add(manager.find(Question.class, i));
        }

        manager.close();

        return newQuestionList;
    }

    //  Get question list by section Name
    public  List<Integer> getQuestionNumberListBySectionName(String sectionName) {
        EntityManager manager = MySQLConnection.getConnection();
        manager.clear();
        sectionName = sectionName.toUpperCase();
        Query query = manager.createQuery("from Question q where q.sectionName =:arg1");
        query.setParameter("arg1", sectionName);
        List<Question> questionList = query.getResultList();
        manager.close();
        return questionList.stream().map(question -> question.getQuestionId()).collect(Collectors.toList());
    }
}
