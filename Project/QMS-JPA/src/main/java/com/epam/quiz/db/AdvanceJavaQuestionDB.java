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

public class AdvanceJavaQuestionDB {
    public static List<Integer> questionNumberListByAdmin = new ArrayList<>();

    public void addQuestionToDB() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        QuestionTag questionTag1 = new QuestionTag(QuestionTopicTag.JDBC, QuestionDifficultyTag.MEDIUM);
        Question question1 = new Question(1,"Which of the following is not a kind of exception that is thrown by the JDBC method?", "DataRounding ", "SQL Exception ", "DataTruncation ", "SQL Warning", "A", questionTag1);

        QuestionTag questionTag2 = new QuestionTag(QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY);
        Question question2 = new Question(2,"Which of the following option leads to the portability and security of Java?", "The applet makes the Java code secure and portable", "Bytecode is executed by JVM", "Use of exception handling", "Dynamic binding between objects", "B", questionTag2);

        QuestionTag questionTag3 = new QuestionTag(QuestionTopicTag.JDBC, QuestionDifficultyTag.EASY);
        Question question3 = new Question(3,"Which of the following is advantage of using JDBC connection pool? ", "Better performance", "Slow performance", "Using more memory", "Using less memory", "A", questionTag3);

        QuestionTag questionTag4 = new QuestionTag(QuestionTopicTag.COMPILER, QuestionDifficultyTag.EASY);
        Question question4 = new Question(4,"To run a compiled java program the machine must have the following loaded and running", "Java virtual machine", "Java compiler", "Java bytecode", "A Web browser", "A", questionTag4);

        QuestionTag questionTag5 = new QuestionTag(QuestionTopicTag.JDBC, QuestionDifficultyTag.EASY);
        Question question5 = new Question(5,"Which is responsible for getting a connection to the database?", "Connection", "Driver", "Statement", "ResultSet", "B", questionTag5);

        QuestionTag questionTag6 = new QuestionTag(QuestionTopicTag.JDBC, QuestionDifficultyTag.MEDIUM);
        Question question6 = new Question(6,"How constructor can be used for a servlet?", "Initialization and Constructor function", "Constructor function", "Setup() method", "Initialization", "A", questionTag6);

        QuestionTag questionTag7 = new QuestionTag(QuestionTopicTag.SWING, QuestionDifficultyTag.EASY);
        Question question7 = new Question(7,"Which package is used for importing swing components?", "Javax.swing", "java.swing", "java.awt.", "All of the mentioned", "A", questionTag7);

        QuestionTag questionTag8 = new QuestionTag(QuestionTopicTag.SERVLET, QuestionDifficultyTag.MEDIUM);
        Question question8 = new Question(8,"__________ is used to read data from a client request.", "ServletResponse", "ServletRequest", "Servlet", "ServletConfig", "B", questionTag8);

        QuestionTag questionTag9 = new QuestionTag(QuestionTopicTag.SERVLET, QuestionDifficultyTag.ADVANCE);
        Question question9 = new Question(9,"Which of the following ways to create a servlet?", "ArrayListUsing Servlet Interface", "B) Using GenericServlet class", "Using HttpServlet class", "All of given", "D", questionTag9);

        QuestionTag questionTag10 = new QuestionTag(QuestionTopicTag.COMPILER, QuestionDifficultyTag.EASY);
        Question question10 = new Question(10,"Which component is used to compile, debug and execute the java program?", "JIT", "JDK", "JVM", "JRE", "B", questionTag10);

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


