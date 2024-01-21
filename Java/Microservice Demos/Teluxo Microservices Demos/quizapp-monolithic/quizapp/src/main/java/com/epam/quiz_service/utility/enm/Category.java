package com.epam.quiz_service.utility.enm;

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
    @Override
    public String toString() {
        return "Category{" +
                "category='" + category + '\'' +
                '}';
    }
}
