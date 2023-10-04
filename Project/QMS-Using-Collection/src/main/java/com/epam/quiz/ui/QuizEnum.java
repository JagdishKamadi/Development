package com.epam.quiz.ui;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum QuizEnum {
    ADD(1, "add"),
    SUB(2, "sub"),
    SHOW(3, "show");
    private final Integer choice;
    private final String operation;
    QuizEnum(Integer choice, String operation) {
        this.operation = operation;
        this.choice = choice;
    }

    public static final Map<Integer, String> operations = Stream.of(values())
            .collect(Collectors.toMap(k -> k.choice, v -> v.operation));
}

