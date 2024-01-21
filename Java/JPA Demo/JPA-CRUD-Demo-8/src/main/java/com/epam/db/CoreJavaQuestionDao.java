package com.epam.db;

import com.epam.model.Question;
import com.epam.model.QuestionTag;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class CoreJavaQuestionDao {

    public List<Question> showData()
    {
        EntityManager manager = MySQLConnection.getConnection();

        Query query = manager.createQuery("select q from Question q");
        List<Question> questionList = query.getResultList();

//
//        AtomicInteger number= new AtomicInteger();
//        questionList.forEach(question -> System.out.println((number.incrementAndGet())+") "+question.getQuestion()
//                +"\t\t["+question.getQuestionTag().getQuestionTopicTag()
//                +"|"+question.getQuestionTag().getQuestionDifficultyTag()+"]"
//                +"\nA) "+question.getOption1()
//                +"\nB) "+question.getOption2()
//                +"\nC) "+question.getOption3()
//                +"\nD) "+question.getOption4()
//                +"\nAnswer "+question.getAnswer()+"\n"));


        manager.getTransaction().commit();
        manager.close();


        return questionList;
    }

    public void addQuestion(Question question, QuestionTag questionTag)
    {
        EntityManager manager = MySQLConnection.getConnection();

        Query q = manager.createQuery("Select MAX(q.questionId) from Question q");
        Integer count = (int)q.getSingleResult();
//        System.out.println("Number of record : "+count);
        question.setQuestionId(count+1);


        manager.persist(question);

        manager.getTransaction().commit();
        manager.close();
    }

    public List<Question> getCustomQuestion(List<Integer> list)
    {
        EntityManager manager = MySQLConnection.getConnection();
        List<Question> questionList = new ArrayList<>();

        for(int i:list)
        {

            questionList.add(manager.find(Question.class,i));
        }

        manager.getTransaction().commit();
        manager.close();

        return questionList;
    }

    @Transactional
    public void deleteAllQuestion()
    {
        EntityManager manager = MySQLConnection.getConnection();
        manager.createQuery("delete from Question").executeUpdate();
        manager.createQuery("delete from QuestionTag").executeUpdate();

        manager.getTransaction().commit();
        manager.close();

    }
}
