package com.epam;

import com.epam.quiz.db.SectionTagDB;
import com.epam.quiz.model.SectionTag;
import com.epam.quiz.service.CreateQuizService;
import com.epam.quiz.service.QuestionValidationService;
import com.epam.quiz.service.SectionValidationService;
import com.epam.quiz.ui.QuizOperation;
import com.epam.quiz.utility.cls.ScannerUtil;

public class App {
    public static void main(String[] args) throws Exception {
            for(int i=0;i<4;i++)
            {
                System.out.println("1) Add new Question");
                System.out.println("2) delete question");
                System.out.println("3) update question");
                System.out.println("Enter new Question");
                char choice = ScannerUtil.getConsoleScanner().next().charAt(0);
                QuizOperation.performOperation(Character.getNumericValue(choice));
            }
    }
}
