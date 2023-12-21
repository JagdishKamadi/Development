package com.epam.quiz.db;

import com.epam.quiz.model.SectionTag;
import com.epam.quiz.utility.cls.MySQLConnection;

import javax.persistence.EntityManager;

public class SectionTagDB {
    public static void addSectionTag()
    {
        EntityManager manager = MySQLConnection.getConnection();
        manager.clear();
        manager.getTransaction().begin();

        SectionTag sectionTag1 = new SectionTag("CORE_JAVA");
        SectionTag sectionTag2 = new SectionTag("ADVANCE_JAVA");
        SectionTag sectionTag3 = new SectionTag("JAVA_EIGHT");

        manager.persist(sectionTag1);
        manager.persist(sectionTag2);
        manager.persist(sectionTag3);


        manager.getTransaction().commit();
        manager.clear();
    }
}
