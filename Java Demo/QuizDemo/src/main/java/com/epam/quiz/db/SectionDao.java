package com.epam.quiz.db;

import com.epam.quiz.model.Question;
import com.epam.quiz.utility.cls.MySQLConnection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SectionDao {
    public static List<Question> getAllQuestionList() {
        EntityManager manager = MySQLConnection.getConnection();
        manager.clear();

        Query query = manager.createQuery("Select q from Question q");
        List<Question> questionList = query.getResultList();
        manager.close();

       return  questionList;
    }

    public static int getSizeOfQuestionList() {
        EntityManager manager = MySQLConnection.getConnection();
        Query q2 = manager.createQuery("Select MAX(q.questionId) from Question q");
        int size = (int) q2.getSingleResult();
        manager.close();

        return size;
    }

    public static void addNewQuestion(Question question) {
        Integer tableSize = QuestionListDB.getSizeOfQuestionList();
        question.getQuestionTag().setQuestionTagId(tableSize + 1);

        EntityManager manager = MySQLConnection.getConnection();
        manager.clear();
        manager.getTransaction().begin();

        manager.persist(question);

        manager.getTransaction().commit();
        manager.close();
    }

    public static List<Integer> getQuestionList() {
        EntityManager manager = MySQLConnection.getConnection();
        manager.clear();

        Query query = manager.createQuery("Select q from Question q");
        List<Question> questionList = query.getResultList();
        manager.close();

        return questionList.stream().map(question -> question.getQuestionId()).collect(Collectors.toList());
    }

    public static List<Question> getQuestionListBySectionName(String sectionName) {
        EntityManager manager = MySQLConnection.getConnection();
        manager.clear();
        sectionName = sectionName.toUpperCase();

        Query query = manager.createQuery("from Question q where q.sectionName=:arg1");
        query.setParameter("arg1", sectionName);
        List<Question> questionList = query.getResultList();
        manager.close();
        return questionList.stream().collect(Collectors.toList());
    }

    public static List<Integer> getQuestionNumberListBySectionName(String sectionName) {
        EntityManager manager = MySQLConnection.getConnection();
        manager.clear();
        sectionName = sectionName.toUpperCase();
        Query query = manager.createQuery("from Question q where q.sectionName =:arg1");
        query.setParameter("arg1", sectionName);
        List<Question> questionList = query.getResultList();
        manager.close();
        return questionList.stream().map(question -> question.getQuestionId()).collect(Collectors.toList());
    }


    public static List<Question> getCustomQuestionList(List<Integer> questionList) {
        EntityManager manager = MySQLConnection.getConnection();
        List<Question> newQuestionList = new ArrayList<>();

        for (Integer i : questionList) {
            newQuestionList.add(manager.find(Question.class, i));
        }

        manager.close();

        return newQuestionList;
    }

    public static void deleteQuestion(final Integer questionNumber) {

        Integer questionTagId;
        EntityManager manager = MySQLConnection.getConnection();

        manager.clear();
        manager.getTransaction().begin();
        Question tempQuestion = manager.find(Question.class,questionNumber);
        questionTagId = tempQuestion.getQuestionTag().getQuestionTagId();
        manager.getTransaction().commit();

        manager.clear();
        manager.getTransaction().begin();
        Query query = manager.createNativeQuery("DELETE FROM Question WHERE questionId = " + questionNumber);
        query.executeUpdate();
        manager.getTransaction().commit();

        manager.clear();

        manager.getTransaction().begin();
        query = manager.createNativeQuery("DELETE FROM QuestionTag WHERE questionTagId = " +questionTagId);
        query.executeUpdate();
        manager.getTransaction().commit();

        manager.close();
        System.out.println("Successfully deleted");
    }

//    public static List<Question> getQuestionListBySection2(String sectionName) {
//        sectionName = sectionName.toUpperCase();
//        EntityManager manager = MySQLConnection.getConnection();
//        Query query = manager.createNamedQuery("SELECT * FROM QuestionTag WHERE questionSectionTag = " + sectionName);
//        List<Question> questionList = query.getResultList();
//        manager.close();
//
//        return questionList;
//    }

    public static void updateQuestion(Integer id, Question question) {
        Integer questionTagId;
        EntityManager manager = MySQLConnection.getConnection();

        manager.clear();
        manager.getTransaction().begin();
        Question tempQuestion = manager.find(Question.class,id);
        questionTagId = tempQuestion.getQuestionTag().getQuestionTagId();
        manager.getTransaction().commit();

        manager.clear();
        manager.getTransaction().begin();

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

        manager.getTransaction().commit();

        manager.clear();
        manager.getTransaction().begin();
        query = manager.createQuery("UPDATE QuestionTag SET questionDifficultyTag = :difficultyTag, questionTopicTag = :topicTag WHERE questionTagId = :id");
        query.setParameter("id", questionTagId);
        query.setParameter("difficultyTag", question.getQuestionTag().getQuestionDifficultyTag());
        query.setParameter("topicTag", question.getQuestionTag().getQuestionTopicTag());
        query.executeUpdate();

        manager.getTransaction().commit();
        manager.close();
    }
}
