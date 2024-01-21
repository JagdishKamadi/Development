package com.epam.quiz.ui;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum QuizEnum {
    ADD(1, "addQuestion"),
    REMOVE(2, "removeQuestion"),
    UPDATE(3, "updateExistingQuestion"),
    ADDNEW(4, "addNewQuestionToDB");

    private final Integer choice;
    private final String operation;
    QuizEnum(Integer choice, String operation) {
        this.operation = operation;
        this.choice = choice;
    }

    public static final Map<Integer, String> operations = Stream.of(values())
            .collect(Collectors.toMap(k -> k.choice, v -> v.operation));
}

