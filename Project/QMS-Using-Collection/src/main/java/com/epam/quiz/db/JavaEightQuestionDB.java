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
 * This class contain all question of java eight and their tag
 */

public class JavaEightQuestionDB {

    public static Map<Integer, Question> questionAnswerMap = new HashMap<>();
    public static HashMap<Integer, QuestionTag> questionTagMap = new HashMap<>();
    public static List<Integer> questionNumberListByAdmin = new ArrayList<>();

    static {
        // added question with option and answer
        questionAnswerMap.put(1,new Question("Lambdas introduced in Java 8 allow us to process_____", "Data as code ", "Code as data", "A & B only", "None of the above","B"));

        questionAnswerMap.put(2,new Question("The newly introduced 'Streams API' is available in which java 8 package?", "java.io.streams", "java.io.stream", "java.util.streams", "java.util.stream","D"));

        questionAnswerMap.put(3,new Question("What class can be used instead of System.getCurrentTimeMillis() to get date and time in Java 8? ", "Clock", "Timer", "Time", "Date","A"));

        questionAnswerMap.put(4,new Question("Lambda expressions in java 8 are based on _____", "Procedural programming", "Functional programming", "Data programming", "All the answers are true","B"));

        questionAnswerMap.put(5,new Question("How many methods exist in a functionalA interface in Java 8?", "3", "2", "1", "0","C"));

        questionAnswerMap.put(6,new Question("In Java 8 interfaces, methods can be ______", "default", "abstract", "Both A and B are true.", "None of the above","C"));

        questionAnswerMap.put(7,new Question("Which of the following is not introduced with Java 8?", "API Stream", "Spliterator", "Lambda Expression", "Serialization","D"));

        questionAnswerMap.put(8,new Question("What is the return type of the lambda expression?", "String", "Object", "Function", "void","C"));

        questionAnswerMap.put(9,new Question("What is the new method introduced in java 8 to iterate through a collection?", "List.for()", "StringList.forEach()", "foreach(String i : StringList)", "for(String i : StringList)","B"));

        questionAnswerMap.put(10,new Question("What are the two types of Streams proposed by Java 8?", "Random and synchronized", "Parallel and random", "Sequential and random", "Sequential and parallel","D"));


        // added the question with Tag
        questionTagMap.put(1,new QuestionTag(QuestionTopicTag.LAMBDA, QuestionDifficultyTag.MEDIUM));
        questionTagMap.put(2,new QuestionTag(QuestionTopicTag.STREAM, QuestionDifficultyTag.EASY));
        questionTagMap.put(3,new QuestionTag(QuestionTopicTag.DATE_TIME_API, QuestionDifficultyTag.ADVANCE));
        questionTagMap.put(4,new QuestionTag(QuestionTopicTag.LAMBDA, QuestionDifficultyTag.EASY));
        questionTagMap.put(5,new QuestionTag(QuestionTopicTag.FUNCTIONAL_INTERFACE, QuestionDifficultyTag.EASY));
        questionTagMap.put(6,new QuestionTag(QuestionTopicTag.FUNCTIONAL_INTERFACE, QuestionDifficultyTag.EASY));
        questionTagMap.put(7,new QuestionTag(QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.MEDIUM));
        questionTagMap.put(8,new QuestionTag(QuestionTopicTag.LAMBDA, QuestionDifficultyTag.EASY));
        questionTagMap.put(9,new QuestionTag(QuestionTopicTag.COLLECTION, QuestionDifficultyTag.MEDIUM));
        questionTagMap.put(10,new QuestionTag(QuestionTopicTag.STREAM, QuestionDifficultyTag.EASY));

    }
}