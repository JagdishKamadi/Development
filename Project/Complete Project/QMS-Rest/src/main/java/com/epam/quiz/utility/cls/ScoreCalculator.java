package com.epam.quiz.utility.cls;

import com.epam.quiz.model.Question;
import com.epam.quiz.utility.enm.SectionTag;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreCalculator {
    private ScoreCalculator()
    {
        throw  new IllegalStateException();
    }
    public static List<Integer> getQuestionIdList(Map<String, String> answerMap) {
        return answerMap
                .keySet()
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int getScore(SectionTag sectionTag) {
        String assumeLevel = sectionTag.toString().toUpperCase();
        return assumeLevel.equalsIgnoreCase("ADVANCE") ? 2 : 1;
    }

    public static int totalScore(List<Question> questionList, Map<String, String> answerMap) {
        int score = 0;
        for (Question question : questionList) {
            if (answerMap.containsKey(String.valueOf(question.getQuestionId()))
                    && answerMap.get(String.valueOf(question.getQuestionId())).equals(question.getAnswer())) {
                score += getScore(question.getSectionTag());
            }

        }
        return score;
    }
}
