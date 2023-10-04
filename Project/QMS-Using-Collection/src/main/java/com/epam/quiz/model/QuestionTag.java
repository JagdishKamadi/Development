package com.epam.quiz.model;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;

/**
 * This is frame  for question difficulty and question topic tag
 */

public class QuestionTag {
    private final QuestionTopicTag questionTopicTag;
    private final QuestionDifficultyTag questionDifficultyTag;

    public QuestionTag(QuestionTopicTag questionTopicTag, QuestionDifficultyTag questionDifficultyTag) {
        this.questionTopicTag = questionTopicTag;
        this.questionDifficultyTag = questionDifficultyTag;
    }

    public QuestionTopicTag getTopicTag() {
        return questionTopicTag;
    }

    public QuestionDifficultyTag getDifficultyTag() {
        return questionDifficultyTag;
    }
}
