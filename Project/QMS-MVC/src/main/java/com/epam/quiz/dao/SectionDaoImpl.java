package com.epam.quiz.dao;


import com.epam.quiz.model.SectionTag;
import com.epam.quiz.utility.cls.MySQLConnection;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SectionDaoImpl implements SectionDao {

    // Add new question section name to DB

    @Override
    public void addNewSectionTagToDB(String sectionName) {
        sectionName = sectionName.toUpperCase();

        EntityManager manager = MySQLConnection.getConnection().createEntityManager();
        manager.clear();
        manager.getTransaction().begin();

        manager.persist(new SectionTag(sectionName));
        manager.getTransaction().commit();
        manager.close();

    }

    // Delete section name from db
    @Override
    public void updateSectionTagFromDB(String oldSectionName, String newSectionName) {
        oldSectionName = oldSectionName.toUpperCase();
        newSectionName = newSectionName.toUpperCase();

        EntityManager manager = MySQLConnection.getConnection().createEntityManager();
        manager.clear();
        manager.getTransaction().begin();

        Query query = manager.createQuery("UPDATE SectionTag SET sectionName = : newSectionName WHERE sectionName = :oldSectionName");
        query.setParameter("oldSectionName", oldSectionName);
        query.setParameter("newSectionName", newSectionName);
        query.executeUpdate();

        Query query1 = manager.createQuery("UPDATE Question SET sectionName = : newSectionName WHERE sectionName = :oldSectionName");
        query1.setParameter("oldSectionName", oldSectionName);
        query1.setParameter("newSectionName", newSectionName);
        query1.executeUpdate();

        manager.getTransaction().commit();
        manager.close();
    }



    // Get the section name list
    @Override
    public List<SectionTag> getSectionNameList() {
        EntityManager manager = MySQLConnection.getConnection().createEntityManager();
        manager.clear();

        Query query = manager.createQuery("Select s from SectionTag s");
        List<SectionTag> sectionList = query.getResultList();
        manager.close();

        return sectionList;
    }

}
