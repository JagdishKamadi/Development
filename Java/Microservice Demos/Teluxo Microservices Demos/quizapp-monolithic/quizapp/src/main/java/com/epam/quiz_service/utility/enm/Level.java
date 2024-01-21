package com.epam.quiz_service.utility.enm;

public enum Level {
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard");

    private String level;

    Level(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
