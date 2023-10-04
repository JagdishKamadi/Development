package com.epam.quiz.db;
import com.epam.quiz.model.Question;
import com.epam.quiz.model.QuestionTag;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class contain all question of advance java and their tag
 */

public class AdvanceJavaQuestionDB {

    public static Map<Integer, Question> questionAnswerMap =  new HashMap<>();
    public static HashMap<Integer, QuestionTag> questionTagMap = new HashMap<>();
    public static List<Integer> questionNumberListByAdmin = new ArrayList<>();

    private final static List<String> tempQuestionOptionList = new ArrayList<>();

    static {
        // added the question with answer and option
        questionAnswerMap.put(1,new Question("Which of the following is not a kind of exception that is thrown by the JDBC method?", "DataRounding ", "SQL Exception ", "DataTruncation ", "SQL Warning","A"));

        questionAnswerMap.put(2,new Question("Which of the following option leads to the portability and security of Java?", "The applet makes the Java code secure and portable", "Bytecode is executed by JVM", "Use of exception handling", "Dynamic binding between objects","B"));

        questionAnswerMap.put(3,new Question("Which of the following is advantage of using JDBC connection pool? ", "Better performance", "Slow performance", "Using more memory", "Using less memory","A"));

        questionAnswerMap.put(4,new Question("To run a compiled java program the machine must have the following loaded and running", "Java virtual machine", "Java compiler", "Java bytecode", "A Web browser","A"));

        questionAnswerMap.put(5,new Question("Which is responsible for getting a connection to the database?", "Connection", "Driver", "Statement", "ResultSet","B"));

        questionAnswerMap.put(6,new Question("How constructor can be used for a servlet?", "Initialization and Constructor function", "Constructor function", "Setup() method", "Initialization","A"));

        questionAnswerMap.put(7,new Question("Which package is used for importing swing components?", "Javax.swing", "java.swing", "java.awt.", "All of the mentioned","A"));

        questionAnswerMap.put(8,new Question("__________ is used to read data from a client request.", "ServletResponse", "ServletRequest", "Servlet", "ServletConfig","B"));

        questionAnswerMap.put(9,new Question("Which of the following ways to create a servlet?", "ArrayListUsing Servlet Interface", "B) Using GenericServlet class", "Using HttpServlet class", "All of given","D"));

        questionAnswerMap.put(10,new Question("Which component is used to compile, debug and execute the java program?", "JIT", "JDK", "JVM", "JRE","B"));

        // added the question with Tag
        questionTagMap.put(1,new QuestionTag(QuestionTopicTag.JDBC, QuestionDifficultyTag.MEDIUM));
        questionTagMap.put(2,new QuestionTag(QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY));
        questionTagMap.put(3,new QuestionTag(QuestionTopicTag.JDBC, QuestionDifficultyTag.EASY));
        questionTagMap.put(4,new QuestionTag(QuestionTopicTag.COMPILER, QuestionDifficultyTag.EASY));
        questionTagMap.put(5,new QuestionTag(QuestionTopicTag.JDBC, QuestionDifficultyTag.EASY));
        questionTagMap.put(6,new QuestionTag(QuestionTopicTag.JDBC, QuestionDifficultyTag.MEDIUM));
        questionTagMap.put(7,new QuestionTag(QuestionTopicTag.SWING, QuestionDifficultyTag.EASY));
        questionTagMap.put(8,new QuestionTag(QuestionTopicTag.SERVLET, QuestionDifficultyTag.MEDIUM));
        questionTagMap.put(9,new QuestionTag(QuestionTopicTag.SERVLET, QuestionDifficultyTag.ADVANCE));
        questionTagMap.put(10,new QuestionTag(QuestionTopicTag.COMPILER, QuestionDifficultyTag.EASY));
    }

}


