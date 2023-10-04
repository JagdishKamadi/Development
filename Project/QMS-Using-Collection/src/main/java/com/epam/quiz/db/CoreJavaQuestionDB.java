package com.epam.quiz.db;
import com.epam.quiz.model.Question;
import com.epam.quiz.model.QuestionTag;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;

import java.util.*;

/**
 * This class contain all question of core java and their tag
 */
public class CoreJavaQuestionDB {

        public static Map<Integer, Question> questionAnswerMap = new HashMap<>();
        public static   HashMap<Integer, QuestionTag> questionTagMap = new HashMap<>();
        public  static List<Integer> questionNumberListByAdmin = new ArrayList<>();

        static {
       questionAnswerMap.put(1,new Question("Which statement is true about Java?", "Java is a sequence-dependent programming language ", "Java is a code dependent programming language ", "Java is a platform-dependent programming language ", "Java is a platform-independent programming language","D"));

       questionAnswerMap.put(2,new Question("What is the extension of java code files?", ".txt", ".pdf", ".sql", ".java","D"));

       questionAnswerMap.put(3,new Question("Who invented Java Programming? ", "Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup","B"));

       questionAnswerMap.put(4,new Question("Which one of the following is not a Java feature?", "Object-oriented", "Use of pointers", "Portable", "Dynamic and Extensible","B"));

       questionAnswerMap.put(5,new Question("Which of these cannot be used for a variable name in Java?", "identifier & keyword", "identifier", "Keyword", "none of the mentioned","C"));

       questionAnswerMap.put(6,new Question("Which of the following is not an OOPS concept in Java?", "Abstraction", "Inheritance", "Compilation", "Encapsulation","C"));

       questionAnswerMap.put(7,new Question("Which exception is thrown when java is out of memory?", "MemoryError", "OutOfMemoryError", "MemoryOutOfBoundsException", "MemoryFullException","B"));

       questionAnswerMap.put(8,new Question("Which of these keywords is used to define interfaces in Java?", "intf", "Intf", "interface", "Interface","C"));

       questionAnswerMap.put(9,new Question("Which of the following is a superclass of every class in Java?", "ArrayList", "Abstract class", "Object class", "String","C"));

       questionAnswerMap.put(10,new Question("Which of the below is not a Java Profiler?", "JProfiler", "Eclipse Profiler", "JVM", "JConsole","C"));


       // added the question with Tag
            questionTagMap.put(1,new QuestionTag(QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY));
            questionTagMap.put(2,new QuestionTag(QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY));
            questionTagMap.put(3,new QuestionTag(QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY));
            questionTagMap.put(4,new QuestionTag(QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY));
            questionTagMap.put(5,new QuestionTag(QuestionTopicTag.KEYWORD, QuestionDifficultyTag.EASY));
            questionTagMap.put(6,new QuestionTag(QuestionTopicTag.OOPS, QuestionDifficultyTag.EASY));
            questionTagMap.put(7,new QuestionTag(QuestionTopicTag.EXCEPTION, QuestionDifficultyTag.MEDIUM));
            questionTagMap.put(8,new QuestionTag(QuestionTopicTag.KEYWORD, QuestionDifficultyTag.EASY));
            questionTagMap.put(9,new QuestionTag(QuestionTopicTag.OOPS, QuestionDifficultyTag.MEDIUM));
            questionTagMap.put(10,new QuestionTag(QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.ADVANCE));
        }

    }
