package com.epam;

import com.epam.model.Answer;
import com.epam.model.Question;
import com.epam.utility.MySQLConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.IOException;


public class App 
{

    public static void main( String[] args ) throws IOException {

        EntityManagerFactory factory = MySQLConnection.getConnection();
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Answer answer = Answer.builder()
                .answerDescription("My name is Jagdish Kamadi").build();

        Question question = Question.builder()
                .questionDescription("What is your name?")
                .answer(answer)
                .build();

//        em.persist(answer);
        em.persist(question);

        em.getTransaction().commit();
        em.close();
    }
}
