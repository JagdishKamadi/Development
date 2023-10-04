package com.epam.quiz.db;

import com.epam.quiz.model.Question;
import com.epam.quiz.model.QuestionTag;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class JavaEightQuestionDB {
    public static List<Integer> questionNumberListByAdmin = new ArrayList<>();

    public void addQuestionToDB() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        QuestionTag questionTag1 = new QuestionTag(QuestionTopicTag.LAMBDA, QuestionDifficultyTag.MEDIUM);
        Question question1 = new Question(1,"Lambdas introduced in Java 8 allow us to process_____", "Data as code ", "Code as data", "A & B only", "None of the above", "B", questionTag1);

        QuestionTag questionTag2 = new QuestionTag(QuestionTopicTag.STREAM, QuestionDifficultyTag.EASY);
        Question question2 = new Question(2,"The newly introduced 'Streams API' is available in which java 8 package?", "java.io.streams", "java.io.stream", "java.util.streams", "java.util.stream", "D", questionTag2);

        QuestionTag questionTag3 = new QuestionTag(QuestionTopicTag.DATE_TIME_API, QuestionDifficultyTag.ADVANCE);
        Question question3 = new Question(3,"What class can be used instead of System.getCurrentTimeMillis() to get date and time in Java 8? ", "Clock", "Timer", "Time", "Date", "A", questionTag3);

        QuestionTag questionTag4 = new QuestionTag(QuestionTopicTag.LAMBDA, QuestionDifficultyTag.EASY);
        Question question4 = new Question(4,"Lambda expressions in java 8 are based on _____", "Procedural programming", "Functional programming", "Data programming", "All the answers are true", "B", questionTag4);

        QuestionTag questionTag5 = new QuestionTag(QuestionTopicTag.FUNCTIONAL_INTERFACE, QuestionDifficultyTag.EASY);
        Question question5 = new Question(5,"How many methods exist in a functionalA interface in Java 8?", "3", "2", "1", "0", "C", questionTag5);

        QuestionTag questionTag6 = new QuestionTag(QuestionTopicTag.FUNCTIONAL_INTERFACE, QuestionDifficultyTag.EASY);
        Question question6 = new Question(6,"In Java 8 interfaces, methods can be ______", "default", "abstract", "Both A and B are true.", "None of the above", "C", questionTag6);

        QuestionTag questionTag7 = new QuestionTag(QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.MEDIUM);
        Question question7 = new Question(7,"Which of the following is not introduced with Java 8?", "API Stream", "Spliterator", "Lambda Expression", "Serialization", "D", questionTag7);

        QuestionTag questionTag8 = new QuestionTag(QuestionTopicTag.LAMBDA, QuestionDifficultyTag.EASY);
        Question question8 = new Question(8,"What is the return type of the lambda expression?", "String", "Object", "Function", "void", "C", questionTag8);

        QuestionTag questionTag9 = new QuestionTag(QuestionTopicTag.COLLECTION, QuestionDifficultyTag.MEDIUM);
        Question question9 = new Question(9,"What is the new method introduced in java 8 to iterate through a collection?", "List.for()", "StringList.forEach()", "foreach(String i : StringList)", "for(String i : StringList)", "B", questionTag9);

        QuestionTag questionTag10 = new QuestionTag(QuestionTopicTag.STREAM, QuestionDifficultyTag.EASY);
        Question question10 = new Question(10,"What are the two types of Streams proposed by Java 8?", "Random and synchronized", "Parallel and random", "Sequential and random", "Sequential and parallel", "D", questionTag10);

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