package com.epam.quiz.ui;
import com.epam.quiz.utility.cls.ColorCode;
import com.epam.quiz.utility.cls.ScannerUtil;
import org.apache.logging.log4j.*;
public class SectionWelcome {
    final private char sectionChoice;
    private final static Logger logger = LogManager.getLogger(SectionWelcome.class);
    public SectionWelcome(char sectionChoice)
    {
        this.sectionChoice = sectionChoice;
    }

    public void sectionWelcomePage()
    {
        try {
            logger.info("\n"+ ColorCode.getRegularColorCode("blue") +"********+| Welcome to "+ getSectionName(sectionChoice) +" Section |+********"+ColorCode.getResetColorCode()+"\n");
            logger.info("No of question : 5");
            logger.info("1 question [easy/medium] : 1 mark");
            logger.info("1 question [hard]        : 2 mark");
            logger.info("No negative marking");
            logger.info("Would you like to start quiz now?");

            char choice = '0';
            while (choice != '1' && choice!='2') {
                logger.info("Press 1 to continue : ");
                logger.info("Press 2 to exit test :");
                choice = ScannerUtil.getConsoleScanner().next().charAt(0);
            }


            if(choice=='2')
            {
                LoginPage loginPage = new LoginPage();
                loginPage.showLoginPage();
            }

            logger.info("\n"+ sectionChoice +" section is going to start within 5 Second,Kindly wait");
            logger.info("Please do not press any key\n");
            Thread.sleep(5000);
        }
        catch (IllegalThreadStateException | InterruptedException e)
        {
            logger.error(e.getMessage());
        } catch (Exception e)
        {
            logger.error("Unknown error! "+e.getMessage());
        }

    }

    private String getSectionName(char sectionChoice)
    {
        return (sectionChoice=='1') ? "Core Java" :(sectionChoice=='2') ? "Advance Java" :"Java Eight";
    }
}
