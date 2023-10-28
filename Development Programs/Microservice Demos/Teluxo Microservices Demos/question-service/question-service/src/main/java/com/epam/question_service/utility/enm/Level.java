package com.epam.quizapp.utility.enm;

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
