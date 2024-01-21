package com.epam;

import com.epam.db.CoreJavaQuestionDB;
import com.epam.model.Question;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class App
{
    public static void main( String[] args )
    {

        CoreJavaQuestionDB coreJavaQuestionDB = new CoreJavaQuestionDB();
        coreJavaQuestionDB.addQuestionToDB();
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
//        EntityManager manager = factory.createEntityManager();
//        manager.getTransaction().begin();
//
//        Query query = manager.createQuery("select q from Question q");
//        List<Question> questionList = query.getResultList();
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
//
//
//        manager.getTransaction().commit();
//        manager.close();
//        factory.close();
    }
}
