package com.epam.quiz.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.epam.quiz.model.Question;
import com.epam.quiz.utility.cls.MySQLConnection;


@Repository
public class QuestionDaoImpl implements QuestionDao {

    // get the all question list
    @Override
    public List<Question> getAllQuestionList() {
        EntityManager manager = MySQLConnection.getConnection().createEntityManager();
        manager.clear();

        Query query = manager.createQuery("Select q from Question q");
        List<Question> questionList = query.getResultList();
        manager.close();

        return questionList;
    }

    //  Add  question
    @Override
    public void addNewQuestionToDB(final Question question) {
        Integer tableSize = getSizeOfQuestionList();
        question.getQuestionTag().setQuestionTagId(tableSize + 1);

        EntityManager manager = MySQLConnection.getConnection().createEntityManager();
        manager.clear();
        manager.getTransaction().begin();

        manager.persist(question);

        manager.getTransaction().commit();
        manager.close();
    }

    //  Remove  question
    @Override
    public void deleteQuestionFromDB(final Integer questionNumber) {
        Integer questionTagId;
        EntityManager manager = MySQLConnection.getConnection().createEntityManager();

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
    @Override
    public void updateQuestionFromDB(final Integer id, Question question) {
        Integer questionTagId;
        EntityManager manager = MySQLConnection.getConnection().createEntityManager();
        manager.clear();
        manager.getTransaction().begin();

        Question tempQuestion = manager.find(Question.class, id);
        questionTagId = tempQuestion.getQuestionTag().getQuestionTagId();

        Query query = manager.createQuery("UPDATE Question SET questionDescription = :que, option1 = :op1, option2 = :op2, option3 = :op3, option4 = :op4, answer =  :ans, sectionName = :sName WHERE questionId = :id");
        query.setParameter("id", id);
        query.setParameter("que", question.getQuestionDescription());
        query.setParameter("op1", question.getOption1());
        query.setParameter("op2", question.getOption2());
        query.setParameter("op3", question.getOption3());
        query.setParameter("op4", question.getOption4());
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
    @Override
    public List<Question> getCustomQuestionList(Set<Integer> questionList) {
        EntityManager manager = MySQLConnection.getConnection().createEntityManager();
        List<Question> newQuestionList = new ArrayList<>();

        for (Integer i : questionList) {
            newQuestionList.add(manager.find(Question.class, i));
        }

        manager.close();

        return newQuestionList;
    }
    
    public Question getQuestionById(final Integer id)
    {
    	  EntityManager manager = MySQLConnection.getConnection().createEntityManager();
      
    	  Question question = manager.find(Question.class, id);
  
          manager.close();

          return question;
    }

    //  Get question list by section Name
    @Override
    public List<Integer> getQuestionNumberListBySectionName(String sectionName) {
        EntityManager manager = MySQLConnection.getConnection().createEntityManager();
        manager.clear();

        sectionName = sectionName.toUpperCase();
        Query query = manager.createQuery("from Question q where q.sectionName =:arg1");
        query.setParameter("arg1", sectionName);
        List<Question> questionList = query.getResultList();

        manager.close();
        return questionList.stream().map(Question::getQuestionId).collect(Collectors.toList());
    }

    public int getCountBySectionName(String sectionName)
    {
    	sectionName = sectionName.toUpperCase();
    	EntityManager manager = MySQLConnection.getConnection().createEntityManager();
    	manager.clear();
    	
    	 sectionName = sectionName.toUpperCase();
         Query query = manager.createQuery("from Question q where q.sectionName =:arg1");
         query.setParameter("arg1", sectionName);
         
         Optional<List<Question>> questionList =Optional.ofNullable(query.getResultList());
        int count;
         if(questionList.isEmpty())
         {
        	 count=0;
         }
         else
         {
        	 count =  questionList.get().size();
         }
    	return count;
    }
    
    public int getSizeOfQuestionList() {
        EntityManager manager = MySQLConnection.getConnection().createEntityManager();
        Query q2 = manager.createQuery("Select MAX(q.questionId) from Question q");
        int size = (int) q2.getSingleResult();
        manager.close();

        return size;
    }
}
