package com.epam.quiz.ui;

import com.epam.quiz.exception.QuestionNotFoundException;
import com.epam.quiz.model.Question;
import com.epam.quiz.model.QuestionTag;
import com.epam.quiz.service.QuestionValidationService;
import com.epam.quiz.service.SectionValidationService;
import com.epam.quiz.utility.cls.ScannerUtil;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuizManipulationImpl implements QuizManipulation {
    private static final Logger logger = LogManager.getLogger(QuizManipulationImpl.class);


    private QuestionValidationService questionValidationService;


    private SectionValidationService sectionValidationService;

    private DisplayTag displayTag;

    private ValidTag validTag;

    public QuizManipulationImpl(QuestionValidationService questionValidationService, SectionValidationService sectionValidationService, DisplayTag displayTag, ValidTag validTag) {
        this.questionValidationService = questionValidationService;
        this.sectionValidationService = sectionValidationService;
        this.displayTag = displayTag;
        this.validTag = validTag;
    }

    @Override
    public void addQuestion() {

        Question question = showQuestionInputFormat();
        boolean result = questionValidationService.addQuestionChecker(question);

        if (result) {
            logger.info("Question added successfully");
        } else {
            logger.error("Something is going wrong!");
        }
    }


    @Override
    public void removeQuestion() {

        logger.info("Enter the question number");
        String questionNumber = ScannerUtil.getConsoleScanner().next();
        boolean result = questionValidationService.deleteQuestionChecker(Integer.parseInt(questionNumber));
        try {
            if (!result) {
                throw new QuestionNotFoundException("Question doesn't exist!");
            }
            logger.info("Question deleted successfully");

        } catch (QuestionNotFoundException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void updateQuestion() {

        logger.info("Enter the question Id");
        String id = ScannerUtil.getConsoleScanner().next();

        boolean result = questionValidationService.isQuestionNumberPresentChecker(Integer.parseInt(id));

        try {
            if (!result) {
                throw new QuestionNotFoundException("Question doesn't exist!");
            }
            Question question = showQuestionInputFormat();
            questionValidationService.updateQuestionChecker(Integer.parseInt(id), question);
            logger.info("Question updated successfully");

        } catch (QuestionNotFoundException e) {
            logger.info(e.getMessage());
        }
    }

    @Override
    public void showQuestion() {

        List<Question> questionList = questionValidationService.getQuestionList();

        questionList.stream().forEach(question -> logger.info("{} ) {} \t\t [{}|{}]", question.getQuestionId(), question.getQuestionDescription(), question.getQuestionTag().getQuestionTopicTag(), question.getQuestionTag().getQuestionDifficultyTag()));

    }

    @Override
    public void addNewSectionTag() {

        logger.info("Enter section tag name ");
        String sectionName = ScannerUtil.getConsoleScanner().next();

        boolean result = sectionValidationService.addSectionTagChecker(sectionName);
        if (result) {
            logger.info("Section tag added successfully");
        } else {
            logger.error("Section tag already present");
        }

    }

    @Override
    public void updateExistingSectionTag() {

        logger.info("Enter old section tag name ");
        String oldSectionName = ScannerUtil.getConsoleScanner().next();
        logger.info("Enter new section tag name ");
        String newSectionName = ScannerUtil.getConsoleScanner().next();

        boolean result = sectionValidationService.updateSectionTagChecker(oldSectionName, newSectionName);
        if (result) {
            logger.info("Section tag added successfully");
        } else {
            logger.error("New section tag already present");
        }
    }

    private Question showQuestionInputFormat() {


        ScannerUtil.getConsoleScanner().nextLine();
        logger.info("Enter the question ");
        String question = ScannerUtil.getConsoleScanner().nextLine();

        logger.info("Enter option1 ");
        String option1 = ScannerUtil.getConsoleScanner().nextLine();

        logger.info("Enter option2 ");
        String option2 = ScannerUtil.getConsoleScanner().nextLine();

        logger.info("Enter option3 ");
        String option3 = ScannerUtil.getConsoleScanner().nextLine();

        logger.info("Enter option4 ");
        String option4 = ScannerUtil.getConsoleScanner().nextLine();

        logger.info("Enter the answer ");
        String answer = ScannerUtil.getConsoleScanner().nextLine();

        logger.info("Available topic ");
        displayTag.showAvailableQuestionTopicTag();

        boolean flag = false;
        String questionTopicTag = "";

        while (!flag) {
            logger.info("Enter question topic name : ");
            questionTopicTag = ScannerUtil.getConsoleScanner().next();
            flag = validTag.isQuestionTopicTagPresent(questionTopicTag);
        }

        logger.info("Available difficulty level ");
        displayTag.showAvailableQuestionDifficultyTag();

        flag = false;
        String questionDifficultyTag = "";

        while (!flag) {
            logger.info("Enter difficulty level");
            questionDifficultyTag = ScannerUtil.getConsoleScanner().next();
            flag = validTag.isQuestionDifficultyTagPresent(questionDifficultyTag);
        }


        logger.info("Available section ");
        displayTag.showAvailableQuestionSectionName();

        flag = false;
        String sectionName = "";

        while (!flag) {
            logger.info("Enter Section name");
            sectionName = ScannerUtil.getConsoleScanner().next();
            flag = validTag.isQuestionSectionNamePresent(sectionName);
        }


        QuestionTag questionTag = new QuestionTag(1, QuestionTopicTag.valueOf(questionTopicTag.toUpperCase()), QuestionDifficultyTag.valueOf(questionDifficultyTag.toUpperCase()));

        Question question1 = new Question(question, option1, option2, option3, option4, answer);
        question1.setSectionName(sectionName);
        question1.setQuestionTag(questionTag);
        return question1;
    }

}
