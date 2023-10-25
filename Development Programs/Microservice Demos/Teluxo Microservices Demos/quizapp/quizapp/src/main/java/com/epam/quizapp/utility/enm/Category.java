package com.epam.quizapp.utility.enm;

public enum Category {
    PYTHON("Python"),
    JAVA("Java"),
    CPP("C++"),
    JAVASCRIPT("JavaScript");

    private String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
