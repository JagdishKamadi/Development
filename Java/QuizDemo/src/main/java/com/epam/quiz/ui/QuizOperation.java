package com.epam.quiz.ui;

import java.lang.reflect.Method;

public class QuizOperation {

    public static void performOperation(final Integer choice) throws Exception {

        Class<?> service = Class.forName("com.epam.quiz.ui.QuizManipulationImpl");
        Method method = service.getDeclaredMethod(QuizEnum.operations.get(choice));
        method.setAccessible(true);
        method.invoke(service.getDeclaredConstructor().newInstance());
    }
}

