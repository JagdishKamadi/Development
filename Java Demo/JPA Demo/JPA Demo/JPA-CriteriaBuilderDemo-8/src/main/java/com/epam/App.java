package com.epam;

import com.epam.model.Question;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        // now start with criteria builder
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Question> cq = cb.createQuery(Question.class);
        Root<Question> questionRoot = cq.from(Question.class);
        cq.orderBy(cb.desc(questionRoot.get("option1")));

        CriteriaQuery<Question> select = cq.select(questionRoot);
        TypedQuery<Question> q = manager.createQuery(select);
        List<Question> list = q.getResultList();

        list.forEach(question -> System.out.println(question.getOption1()));

        manager.getTransaction().commit();
        manager.close();
        factory.close();

    }
}
