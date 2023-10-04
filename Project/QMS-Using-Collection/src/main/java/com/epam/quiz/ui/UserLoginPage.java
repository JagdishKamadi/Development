package com.epam.quiz.ui;
import com.epam.quiz.dao.QuizSection;
import com.epam.quiz.dao.QuizSectionFactory;
import com.epam.quiz.dao.UserCredentialDao;
import com.epam.quiz.service.PageSwitcherService;
import com.epam.quiz.service.StartQuizService;
import com.epam.quiz.utility.cls.ScannerUtil;
import org.apache.logging.log4j.*;

public class UserLoginPage {
    private static final Logger logger = LogManager.getLogger(UserLoginPage.class);
    public void showUserPage()
    {
        logger.info("Welcome "+ new UserCredentialDao().getUserName()+"\n");
        logger.info("-------+ Choose the section to take the quiz +-------");
        logger.info("1) Core Java Section");
        logger.info("2) Advance Java Section");
        logger.info("3) Java Eight Section");
        logger.info("4) Log out");

        char choice ='0';

        while(Character.getNumericValue(choice)>=5 || Character.getNumericValue(choice)<=0)
        {
            choice = ScannerUtil.getConsoleScanner().next().charAt(0);
        }

        if(choice=='4')
        {
            PageSwitcherService pageSwitcherService = new PageSwitcherService();
            pageSwitcherService.getLogOut();
        }

        SectionWelcome sectionWelcome = new SectionWelcome(choice);
        sectionWelcome.sectionWelcomePage();

        QuizSection quizSection = QuizSectionFactory.getInstance(Character.getNumericValue(choice));
        StartQuizService startQuizService = new StartQuizService();
        startQuizService.displayQuestionBySection(quizSection);
    }


}
