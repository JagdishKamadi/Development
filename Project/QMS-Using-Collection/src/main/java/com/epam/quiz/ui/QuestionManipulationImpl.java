package com.epam.quiz.ui;
import com.epam.quiz.dao.QuizSection;
import com.epam.quiz.model.Question;
import com.epam.quiz.model.QuestionTag;
import com.epam.quiz.utility.cls.DisplayTag;
import com.epam.quiz.utility.cls.ScannerUtil;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;
import org.apache.logging.log4j.*;
import java.util.InputMismatchException;


public class QuestionManipulationImpl implements QuestionManipulation {
    private static final Logger logger = LogManager.getLogger(QuestionManipulation.class);


    @Override
    public void addQuestion(QuizSection quizSection) {
        try{
            logger.info("Enter question number ");
            byte questionNumber = ScannerUtil.getConsoleScanner().nextByte();
            if(questionNumber>quizSection.getSectionQuestion().size() || questionNumber<=0)
            {
                logger.info("Invalid question number!");
            } else if (quizSection.getAdminQuestionList().contains(questionNumber)) {
                logger.info("Question already present!");
            } else {
                quizSection.setAdminQuestionList(questionNumber);
                logger.info("Added question successfully");
                showQuestionStatus(quizSection);
            }
        }catch (InputMismatchException e){
            logger.error("Enter proper choice");
        }
    }

    @Override
    public void removeQuestion(QuizSection quizSection) {
        try{
            logger.info("Enter question number " );
            int questionNumber = ScannerUtil.getConsoleScanner().nextInt();
            if(!quizSection.getAdminQuestionList().contains(questionNumber))
            {
                logger.info("Question doesn't exist");
            }
            else {
                quizSection.getAdminQuestionList().remove(Integer.valueOf(questionNumber));
                logger.info("Removed question successfully");
                showQuestionStatus(quizSection);
            }
        }catch (InputMismatchException e)
        {
            logger.error("Enter proper choice");
        }
    }

    @Override
    public void updateExistingQuestion(QuizSection quizSection) {
        try{
            logger.info("Enter the question number which want to remove ");
            int questionNumber = ScannerUtil.getConsoleScanner().nextInt();
            logger.info("Enter the question number which want to update");
            int updateQuestionNumber = ScannerUtil.getConsoleScanner().nextInt();

            if(quizSection.getAdminQuestionList().contains(questionNumber)
                    && (updateQuestionNumber>=1 && updateQuestionNumber<=quizSection.getSectionQuestion().size()))
                {
                    int index = quizSection.getAdminQuestionList().indexOf(Integer.valueOf(questionNumber));
                    quizSection.getAdminQuestionList().set(index,updateQuestionNumber);
                    showQuestionStatus(quizSection);
                }
            }catch (InputMismatchException ex)
            {
                logger.error("Enter proper choice");
            }
    }

    @Override
    public void addNewQuestionToDB(QuizSection quizSection) {
            ScannerUtil.getConsoleScanner().nextLine();
            logger.info("Enter the question ");
            String question = ScannerUtil.getConsoleScanner().nextLine();
            logger.info("Enter option1");
            String option1 = ScannerUtil.getConsoleScanner().nextLine();
            logger.info("Enter option2");
            String option2 = ScannerUtil.getConsoleScanner().nextLine();
            logger.info("Enter option3");
            String option3 = ScannerUtil.getConsoleScanner().nextLine();
            logger.info("Enter option4");
            String option4 = ScannerUtil.getConsoleScanner().nextLine();
            logger.info("Enter the answer");
            String answer = ScannerUtil.getConsoleScanner().nextLine();
            logger.info("Enter topic name");
            logger.info("Available topic ");
            DisplayTag.showAvailableQuestionTopicTag();
            boolean flag = false;
            String questionTopicTag="";

            while(!flag){
                logger.info("Enter question topic name : ");
                questionTopicTag = ScannerUtil.getConsoleScanner().next();
                flag = DisplayTag.isQuestionTopicTagPresent(questionTopicTag);
            }

            logger.info("Enter difficulty level");
            logger.info("Available difficulty level ");
            DisplayTag.showAvailableQuestionDifficultyTag();
            flag = false;
            String questionDifficultyTag="";

            while(!flag){
                logger.info("Enter question topic name : ");
                questionDifficultyTag = ScannerUtil.getConsoleScanner().next();
                flag = DisplayTag.isQuestionDifficultyTagPresent(questionDifficultyTag);
            }

        Question question1 = new Question(question,option1,option2,option3,option4,answer);
        QuestionTag questionTag = new QuestionTag(QuestionTopicTag.valueOf(questionTopicTag.toUpperCase()), QuestionDifficultyTag.valueOf(questionDifficultyTag.toUpperCase()));
        quizSection.updateQuestionList(question1,questionTag);
        logger.info("Question entered successfully");
        QuizSetter quizSetter = new QuizSetter();
        quizSetter.showAllQuestion(quizSection);

    }

    private void showQuestionStatus(QuizSection quizSection)
    {
        logger.info("Question status : "+quizSection.getAdminQuestionList());
    }
}
