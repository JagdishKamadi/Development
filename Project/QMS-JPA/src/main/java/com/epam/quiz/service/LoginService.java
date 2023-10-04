package com.epam.quiz.service;
import com.epam.quiz.dao.UserCredentialDao;
import com.epam.quiz.ui.AcceptDetail;
import com.epam.quiz.ui.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.List;

public class LoginService {
    private static final Logger logger = LogManager.getLogger(LoginService.class);

    public void acceptLoginDetails(char typeOfUser)
    {
        boolean flag=false;
        String username = "";

        while(!flag)
        {
            List<String> usernameAndPasswordDataList = AcceptDetail.getUsernameAndPasswordDetail();
            if(typeOfUser=='1')
            {
                flag = usernameAndPasswordDataList.get(0).equals("Admin") && usernameAndPasswordDataList.get(1).equals("Admin@99");
            }
            else {
                flag = new UserCredentialDao().isUserLogin(usernameAndPasswordDataList.get(0),usernameAndPasswordDataList.get(1));
            }

            if(!flag)
            {
                logger.error("Username or Password wrong");
            }
            username = usernameAndPasswordDataList.get(0);
        }


        logger.info("Login successfully\n");
    }


    /**
     * this method show the all process which is required to registered
     * if user already exist then show the message and send back to home page again
     * if user registered successfully then show successfully message
     */

    public void register()
    {
        List<String> usernameAndPasswordDataList = AcceptDetail.getUsernameAndPasswordDetail();
        UserCredentialDao userCredentialDao = new UserCredentialDao();
        boolean result = userCredentialDao.registerUser(usernameAndPasswordDataList.get(0),usernameAndPasswordDataList.get(1));

        if(result){
            logger.error("user already exist!");
        }
        else {
            logger.info("Registered successfully");
        }

        try{
            LoginPage loginPage = new LoginPage();
            loginPage.showLoginPage();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }
}
