package com.epam.quiz.ui;

import java.lang.reflect.Method;

public class QuizOperationService {

    public static void performOperation(final Integer choice) throws Exception {

            Class<?> service = Class.forName("QuizUIImpl");
            Method method = service.getDeclaredMethod(QuizEnum.operations.get(choice));
            method.setAccessible(true);
            method.invoke(service.getDeclaredConstructor().newInstance());


    }
}

