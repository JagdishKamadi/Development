package com.epam.one_to_one;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * here in this example we are setting the bidirectional one to one map
 */
public class QuestionAnswerTest {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Question question1 = new Question();
        question1.setQuestionNo(2);
        question1.setQuestion("What is compiler");
        Answer answer1 = new Answer();
        answer1.setAnswerNo(102);
        answer1.setAnswer("It is use to convert the program code into the machine code");
        question1.setAnswer(answer1);
        answer1.setQuestion(question1);

        manager.persist(answer1);
        manager.persist(question1);

        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
