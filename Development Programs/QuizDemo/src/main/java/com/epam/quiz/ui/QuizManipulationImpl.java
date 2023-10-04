package com.epam.quiz.ui;

import com.epam.quiz.model.Question;
import com.epam.quiz.model.QuestionTag;
import com.epam.quiz.service.QuestionValidationService;
import com.epam.quiz.utility.cls.ScannerUtil;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;

public class QuizManipulationImpl implements QuizManipulation {
    QuestionValidationService questionValidationService;

    public QuizManipulationImpl() {
        questionValidationService = new QuestionValidationService();
    }

    @Override
    public void addQuestion() {
        Question question = showQuestionInputFormat();
        boolean result = questionValidationService.addQuestionChecker(question);

        if (result) {
            System.out.println("Question added successfully");
        } else {
            System.out.println("Something is going wrong!");
        }
    }

    @Override
    public void updateQuestion() {
        System.out.println("Enter the question Id");
        String id = ScannerUtil.getConsoleScanner().next();

//        ScannerUtil.getConsoleScanner().nextLine();
        Question question = showQuestionInputFormat();
        boolean result = questionValidationService.updateQuestionChecker(Integer.parseInt(id), question);

        if (result) {
            System.out.println("Question updated successfully");
        } else {
            System.out.println("Question doesn't exist");
        }
    }
    @Override
    public void removeQuestion() {
        System.out.println("Enter the question number");
        String questionNumber = ScannerUtil.getConsoleScanner().next();
        boolean result = questionValidationService.deleteQuestionChecker(Integer.parseInt(questionNumber));

        if (result) {
            System.out.println("Question deleted successfully");
        } else {
            System.out.println("Question doesn't exist");
        }

    }


    private Question showQuestionInputFormat() {
        DisplayTag displayTag = new DisplayTag();
        ValidTag validTag = new ValidTag();

        ScannerUtil.getConsoleScanner().nextLine();
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

        System.out.println("Available topic ");
        displayTag.showAvailableQuestionTopicTag();

        boolean flag = false;
        String questionTopicTag = "";

        while (!flag) {
            System.out.println("Enter question topic name : ");
            questionTopicTag = ScannerUtil.getConsoleScanner().next();
            flag = validTag.isQuestionTopicTagPresent(questionTopicTag);
        }

        System.out.println("Available difficulty level ");
        displayTag.showAvailableQuestionDifficultyTag();

        flag = false;
        String questionDifficultyTag = "";

        while (!flag) {
            System.out.println("Enter difficulty level");
            questionDifficultyTag = ScannerUtil.getConsoleScanner().next();
            flag = validTag.isQuestionDifficultyTagPresent(questionDifficultyTag);
        }


        System.out.println("Available section ");
        displayTag.showAvailableQuestionSectionName();

        flag = false;
        String sectionName = "";

        while (!flag) {
            System.out.println("Enter Section name");
            sectionName = ScannerUtil.getConsoleScanner().next();
            flag = validTag.isQuestionSectionNamePresent(sectionName);
        }


        QuestionTag questionTag = new QuestionTag(1, QuestionTopicTag.valueOf(questionTopicTag.toUpperCase()),
                QuestionDifficultyTag.valueOf(questionDifficultyTag.toUpperCase()));

        Question question1 = new Question(question, option1, option2, option3, option4, answer,
                sectionName.toUpperCase(), questionTag);

        Question question2 = new Question(question, option1, option2, option3, option4, answer, sectionName.toUpperCase(), questionTag);
        return question2;
    }
}
