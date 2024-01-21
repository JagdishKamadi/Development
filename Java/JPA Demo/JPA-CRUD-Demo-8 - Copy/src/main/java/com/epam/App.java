package com.epam;

import com.epam.db.CoreJavaQuestionDB;
import com.epam.db.CoreJavaQuestionDao;
import com.epam.model.Question;
import com.epam.model.QuestionTag;
import com.epam.utility.cls.DisplayTag;
import com.epam.utility.cls.ScannerUtil;
import com.epam.utility.enm.QuestionDifficultyTag;
import com.epam.utility.enm.QuestionTopicTag;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args) {

        CoreJavaQuestionDB coreJavaQuestionDB = new CoreJavaQuestionDB();
        coreJavaQuestionDB.addQuestionToDB();

//        QuestionBank questionBank = new QuestionBank();
//        List<Question> questionList = questionBank.showData();
//        AtomicInteger number= new AtomicInteger();
//        questionList.forEach(question -> System.out.println((number.incrementAndGet())+") "+question.getQuestion()
//                +"\t\t["+question.getQuestionTag().getQuestionTopicTag()
//                +"|"+question.getQuestionTag().getQuestionDifficultyTag()+"]"
//                +"\nA) "+question.getOption1()
//                +"\nB) "+question.getOption2()
//                +"\nC) "+question.getOption3()
//                +"\nD) "+question.getOption4()
//                +"\nAnswer "+question.getAnswer()+"\n"));

//        CoreJavaQuestionDao coreJavaQuestionDao = new CoreJavaQuestionDao();
//        List<Question> questionList = coreJavaQuestionDao.getCustomQuestion(new ArrayList<>(Arrays.asList(1,10,5,3,4)));
//
//        questionList.forEach(question -> System.out.println(question));

        CoreJavaQuestionDao coreJavaQuestionDao = new CoreJavaQuestionDao();



        List<Question> questionList = coreJavaQuestionDao.showData();
        AtomicInteger number= new AtomicInteger();
        questionList.forEach(question -> System.out.println((number.incrementAndGet())+") "+question.getQuestion()
                +"\t\t["+question.getQuestionTag().getQuestionTopicTag()
                +"|"+question.getQuestionTag().getQuestionDifficultyTag()+"]"
                +"\nA) "+question.getOption1()
                +"\nB) "+question.getOption2()
                +"\nC) "+question.getOption3()
                +"\nD) "+question.getOption4()
                +"\nAnswer "+question.getAnswer()+"\n"));

    }

    public static void addNewQuestionToDB() {

        System.out.println("Enter the question ");
        String question = ScannerUtil.getConsoleScanner().nextLine();
        System.out.println("Enter option1");
        String option1 = ScannerUtil.getConsoleScanner().nextLine();
        System.out.println("Enter option2");
        String option2 = ScannerUtil.getConsoleScanner().nextLine();
        System.out.println("Enter option3");
        String option3 = ScannerUtil.getConsoleScanner().nextLine();
        System.out.println("Enter option4");
        String option4 = ScannerUtil.getConsoleScanner().nextLine();
        System.out.println("Enter the answer");
        String answer = ScannerUtil.getConsoleScanner().nextLine();
        System.out.println("Enter topic name");
        System.out.println("Available topic ");
        DisplayTag.showAvailableQuestionTopicTag();
        boolean flag = false;
        String questionTopicTag="";

        while(!flag){
            System.out.println("Enter question topic name : ");
            questionTopicTag = ScannerUtil.getConsoleScanner().next();
            flag = DisplayTag.isQuestionTopicTagPresent(questionTopicTag);
        }

        System.out.println("Enter difficulty level");
        System.out.println("Available difficulty level ");
        DisplayTag.showAvailableQuestionDifficultyTag();
        flag = false;
        String questionDifficultyTag="";

        while(!flag){
            System.out.println("Enter question topic name : ");
            questionDifficultyTag = ScannerUtil.getConsoleScanner().next();
            flag = DisplayTag.isQuestionDifficultyTagPresent(questionDifficultyTag);
        }


        QuestionTag questionTag = new QuestionTag(QuestionTopicTag.valueOf(questionTopicTag.toUpperCase()), QuestionDifficultyTag.valueOf(questionDifficultyTag.toUpperCase()));
        Question question1 = new Question(1,question,option1,option2,option3,option4,answer,questionTag);
        CoreJavaQuestionDao coreJavaQuestionDao = new CoreJavaQuestionDao();
        coreJavaQuestionDao.addQuestion(question1,questionTag);

    }
}
