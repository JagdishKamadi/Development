package com.epam.db;

import com.epam.model.Question;
import com.epam.model.QuestionTag;
import com.epam.utility.enm.QuestionDifficultyTag;
import com.epam.utility.enm.QuestionTopicTag;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CoreJavaQuestionDB {

    public void addQuestionToDB() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        QuestionTag questionTag1 = new QuestionTag(QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY);
        Question question1 =  new Question("Which statement is true about Java?", "Java is a sequence-dependent programming language ", "Java is a code dependent programming language ", "Java is a platform-dependent programming language ", "Java is a platform-independent programming language", "D",questionTag1);

        QuestionTag questionTag2 = new QuestionTag(QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY);
        Question question2 =  new Question("What is the extension of java code files?", ".txt", ".pdf", ".sql", ".java", "D",questionTag2);

        QuestionTag questionTag3 = new QuestionTag(QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY);
        Question question3 =  new Question("Who invented Java Programming? ", "Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup",
                "B",questionTag3);

        QuestionTag questionTag4 = new QuestionTag(QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY);
        Question question4 =  new Question("Which one of the following is not a Java feature?", "Object-oriented", "Use of pointers", "Portable", "Dynamic and Extensible",
                "B",questionTag4);

        QuestionTag questionTag5 = new QuestionTag(QuestionTopicTag.KEYWORD, QuestionDifficultyTag.EASY);
        Question question5 =  new Question("Which of these cannot be used for a variable name in Java?", "identifier & keyword", "identifier", "Keyword", "none of the mentioned",
                "C",questionTag5);

        QuestionTag questionTag6 = new QuestionTag(QuestionTopicTag.OOPS, QuestionDifficultyTag.EASY);
        Question question6 =  new Question("Which of the following is not an OOPS concept in Java?", "Abstraction", "Inheritance", "Compilation", "Encapsulation",
                "C",questionTag6);

        QuestionTag questionTag7 = new QuestionTag(QuestionTopicTag.EXCEPTION, QuestionDifficultyTag.MEDIUM);
        Question question7 =  new Question("Which exception is thrown when java is out of memory?", "MemoryError", "OutOfMemoryError", "MemoryOutOfBoundsException", "MemoryFullException",
                "B",questionTag7);

        QuestionTag questionTag8 = new QuestionTag(QuestionTopicTag.KEYWORD, QuestionDifficultyTag.EASY);
        Question question8 =  new Question("Which of these keywords is used to define interfaces in Java?", "intf", "Intf", "interface", "Interface",
                "C",questionTag8);

        QuestionTag questionTag9 = new QuestionTag(QuestionTopicTag.OOPS, QuestionDifficultyTag.MEDIUM);
        Question question9 =  new Question("Which of the following is a superclass of every class in Java?", "ArrayList", "Abstract class", "Object class", "String",
                "C",questionTag9);

        QuestionTag questionTag10 = new QuestionTag(QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.ADVANCE);
        Question question10 =  new Question("Which of the below is not a Java Profiler?", "JProfiler", "Eclipse Profiler", "JVM", "JConsole",
                "C",questionTag10);


        manager.persist(question1);
        manager.persist(question2);
        manager.persist(question3);
        manager.persist(question4);
        manager.persist(question5);
        manager.persist(question6);
        manager.persist(question7);
        manager.persist(question8);
        manager.persist(question9);
        manager.persist(question10);


        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }



}