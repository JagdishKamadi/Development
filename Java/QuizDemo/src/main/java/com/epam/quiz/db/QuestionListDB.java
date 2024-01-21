package com.epam.quiz.db;

import com.epam.quiz.model.Question;
import com.epam.quiz.model.QuestionTag;
import com.epam.quiz.utility.cls.MySQLConnection;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class QuestionListDB {

    public static void addData() {
        EntityManager manager = MySQLConnection.getConnection();
        manager.clear();
        manager.getTransaction().begin();

        // core java question
        QuestionTag questionTag1 = new QuestionTag(1,QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY);
        Question question1 = new Question("Which statement is true about Java?", "Java is a sequence-dependent programming language ", "Java is a code dependent programming language ", "Java is a platform-dependent programming language ", "Java is a platform-independent programming language", "D", "CORE_JAVA",questionTag1);

        QuestionTag questionTag2 = new QuestionTag(2,QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY);
        Question question2 = new Question("What is the extension of java code files?", ".txt", ".pdf", ".sql", ".java", "D","CORE_JAVA",questionTag2);

        QuestionTag questionTag3 = new QuestionTag(3,QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY);
        Question question3 = new Question("Who invented Java Programming? ", "Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup",
                "B","CORE_JAVA", questionTag3);

        QuestionTag questionTag4 = new QuestionTag(4,QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY);
        Question question4 = new Question("Which one of the following is not a Java feature?", "Object-oriented", "Use of pointers", "Portable", "Dynamic and Extensible",
                "B","CORE_JAVA", questionTag4);

        QuestionTag questionTag5 = new QuestionTag(5,QuestionTopicTag.KEYWORD, QuestionDifficultyTag.EASY);
        Question question5 = new Question("Which of these cannot be used for a variable name in Java?", "identifier & keyword", "identifier", "Keyword", "none of the mentioned",
                "C","CORE_JAVA",questionTag5);

        QuestionTag questionTag6 = new QuestionTag(6,QuestionTopicTag.OOPS, QuestionDifficultyTag.EASY);
        Question question6 = new Question("Which of the following is not an OOPS concept in Java?", "Abstraction", "Inheritance", "Compilation", "Encapsulation",
                "C","CORE_JAVA",questionTag6);
        QuestionTag questionTag7 = new QuestionTag(7,QuestionTopicTag.EXCEPTION, QuestionDifficultyTag.MEDIUM);
        Question question7 = new Question("Which exception is thrown when java is out of memory?", "MemoryError", "OutOfMemoryError", "MemoryOutOfBoundsException", "MemoryFullException",
                "B", "CORE_JAVA",questionTag7);

        QuestionTag questionTag8 = new QuestionTag(8,QuestionTopicTag.KEYWORD, QuestionDifficultyTag.EASY);
        Question question8 = new Question("Which of these keywords is used to define interfaces in Java?", "intf", "Intf", "interface", "Interface",
                "C", "CORE_JAVA", questionTag8);

        QuestionTag questionTag9 = new QuestionTag(9,QuestionTopicTag.OOPS, QuestionDifficultyTag.MEDIUM);
        Question question9 = new Question("Which of the following is a superclass of every class in Java?", "ArrayList", "Abstract class", "Object class", "String",
                "C", "CORE_JAVA",questionTag9);

        QuestionTag questionTag10 = new QuestionTag(10,QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.ADVANCE);
        Question question10 = new Question("Which of the below is not a Java Profiler?", "JProfiler", "Eclipse Profiler", "JVM", "JConsole",
                "C","CORE_JAVA",questionTag10);
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

        // java eight question
        manager.clear();
        manager.getTransaction().begin();

         questionTag1 = new QuestionTag(11,QuestionTopicTag.LAMBDA, QuestionDifficultyTag.MEDIUM);
         question1 = new Question("Lambdas introduced in Java 8 allow us to process_____", "Data as code ", "Code as data", "A & B only", "None of the above", "B","JAVA_EIGHT", questionTag1);

         questionTag2 = new QuestionTag(12,QuestionTopicTag.STREAM, QuestionDifficultyTag.EASY);
         question2 = new Question("The newly introduced 'Streams API' is available in which java 8 package?", "java.io.streams", "java.io.stream", "java.util.streams", "java.util.stream", "D","JAVA_EIGHT", questionTag2);

         questionTag3 = new QuestionTag(13,QuestionTopicTag.DATE_TIME_API, QuestionDifficultyTag.ADVANCE);
         question3 = new Question("What class can be used instead of System.getCurrentTimeMillis() to get date and time in Java 8? ", "Clock", "Timer", "Time", "Date", "A","JAVA_EIGHT", questionTag3);

         questionTag4 = new QuestionTag(14,QuestionTopicTag.LAMBDA, QuestionDifficultyTag.EASY);
         question4 = new Question("Lambda expressions in java 8 are based on _____", "Procedural programming", "Functional programming", "Data programming", "All the answers are true", "B", "JAVA_EIGHT",questionTag4);

         questionTag5 = new QuestionTag(15,QuestionTopicTag.FUNCTIONAL_INTERFACE, QuestionDifficultyTag.EASY);
         question5 = new Question("How many methods exist in a functionalA interface in Java 8?", "3", "2", "1", "0", "C","JAVA_EIGHT", questionTag5);

         questionTag6 = new QuestionTag(16,QuestionTopicTag.FUNCTIONAL_INTERFACE, QuestionDifficultyTag.EASY);
         question6 = new Question("In Java 8 interfaces, methods can be ______", "default", "abstract", "Both A and B are true.", "None of the above", "C", "JAVA_EIGHT",questionTag6);

         questionTag7 = new QuestionTag(17,QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.MEDIUM);
         question7 = new Question("Which of the following is not introduced with Java 8?", "API Stream", "Spliterator", "Lambda Expression", "Serialization", "D", "JAVA_EIGHT",questionTag7);

         questionTag8 = new QuestionTag(18,QuestionTopicTag.LAMBDA, QuestionDifficultyTag.EASY);
         question8 = new Question("What is the return type of the lambda expression?", "String", "Object", "Function", "void", "C", "JAVA_EIGHT",questionTag8);

         questionTag9 = new QuestionTag(19,QuestionTopicTag.COLLECTION, QuestionDifficultyTag.MEDIUM);
         question9 = new Question("What is the new method introduced in java 8 to iterate through a collection?", "List.for()", "StringList.forEach()", "foreach(String i : StringList)", "for(String i : StringList)", "B", "JAVA_EIGHT",questionTag9);

         questionTag10 = new QuestionTag(20,QuestionTopicTag.STREAM, QuestionDifficultyTag.EASY);
         question10 = new Question( "What are the two types of Streams proposed by Java 8?", "Random and synchronized", "Parallel and random", "Sequential and random", "Sequential and parallel", "D","JAVA_EIGHT", questionTag10);

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

//         advance java question

        manager.clear();
        manager.getTransaction().begin();
        questionTag1 = new QuestionTag(21,QuestionTopicTag.JDBC, QuestionDifficultyTag.MEDIUM);
        question1 = new Question("Which of the following is not a kind of exception that is thrown by the JDBC method?", "DataRounding ", "SQL Exception ", "DataTruncation ", "SQL Warning", "A","ADVANCE_JAVA", questionTag1);

        questionTag2 = new QuestionTag(22,QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY);
        question2 = new Question("Which of the following option leads to the portability and security of Java?", "The applet makes the Java code secure and portable", "Bytecode is executed by JVM", "Use of exception handling", "Dynamic binding between objects", "B","ADVANCE_JAVA", questionTag2);

        questionTag3 = new QuestionTag(23,QuestionTopicTag.JDBC, QuestionDifficultyTag.EASY);
        question3 = new Question("Which of the following is advantage of using JDBC connection pool? ", "Better performance", "Slow performance", "Using more memory", "Using less memory", "A","ADVANCE_JAVA", questionTag3);

        questionTag4 = new QuestionTag(24,QuestionTopicTag.COMPILER, QuestionDifficultyTag.EASY);
        question4 = new Question("To run a compiled java program the machine must have the following loaded and running", "Java virtual machine", "Java compiler", "Java bytecode", "A Web browser", "A","ADVANCE_JAVA", questionTag4);

        questionTag5 = new QuestionTag(25,QuestionTopicTag.JDBC, QuestionDifficultyTag.EASY);
        question5 = new Question("Which is responsible for getting a connection to the database?", "Connection", "Driver", "Statement", "ResultSet", "B", "ADVANCE_JAVA",questionTag5);

        questionTag6 = new QuestionTag(26,QuestionTopicTag.JDBC, QuestionDifficultyTag.MEDIUM);
        question6 = new Question("How constructor can be used for a servlet?", "Initialization and Constructor function", "Constructor function", "Setup() method", "Initialization", "A", "ADVANCE_JAVA",questionTag6);

        questionTag7 = new QuestionTag(27,QuestionTopicTag.SWING, QuestionDifficultyTag.EASY);
        question7 = new Question("Which package is used for importing swing components?", "Javax.swing", "java.swing", "java.awt.", "All of the mentioned", "A", "ADVANCE_JAVA",questionTag7);

        questionTag8 = new QuestionTag(28,QuestionTopicTag.SERVLET, QuestionDifficultyTag.MEDIUM);
        question8 = new Question("__________ is used to read data from a client request.", "ServletResponse", "ServletRequest", "Servlet", "ServletConfig", "B","ADVANCE_JAVA", questionTag8);

        questionTag9 = new QuestionTag(29,QuestionTopicTag.SERVLET, QuestionDifficultyTag.ADVANCE);
        question9 = new Question("Which of the following ways to create a servlet?", "ArrayListUsing Servlet Interface", "B) Using GenericServlet class", "Using HttpServlet class", "All of given", "D","ADVANCE_JAVA", questionTag9);

        questionTag10 = new QuestionTag(30,QuestionTopicTag.COMPILER, QuestionDifficultyTag.EASY);
        question10 = new Question("Which component is used to compile, debug and execute the java program?", "JIT", "JDK", "JVM", "JRE", "B", "ADVANCE_JAVA",questionTag10);

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
    }
    public static int getSizeOfQuestionList()
    {
        EntityManager manager = MySQLConnection.getConnection();
        Query q2 = manager.createQuery("Select MAX(q.questionId) from Question q");
        int size = (int) q2.getSingleResult();
        manager.close();

        return size;
    }
}
