package com.epam.model;

import com.epam.utility.enm.QuestionDifficultyTag;
import com.epam.utility.enm.QuestionTopicTag;
import javax.persistence.*;

@Entity
public class QuestionTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;

    @Enumerated(EnumType.STRING)
    private QuestionTopicTag questionTopicTag;

    @Enumerated(EnumType.STRING)
    private QuestionDifficultyTag questionDifficultyTag;

    public QuestionTag() {
    }

    public QuestionTag( QuestionTopicTag questionTopicTag, QuestionDifficultyTag questionDifficultyTag) {
        this.questionTopicTag = questionTopicTag;
        this.questionDifficultyTag = questionDifficultyTag;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public QuestionTopicTag getQuestionTopicTag() {
        return questionTopicTag;
    }

    public void setQuestionTopicTag(QuestionTopicTag questionTopicTag) {
        this.questionTopicTag = questionTopicTag;
    }

    public QuestionDifficultyTag getQuestionDifficultyTag() {
        return questionDifficultyTag;
    }

    public void setQuestionDifficultyTag(QuestionDifficultyTag questionDifficultyTag) {
        this.questionDifficultyTag = questionDifficultyTag;
    }

    @Override
    public String toString() {
        return "QuestionTag{" +
                "questionId=" + questionId +
                ", questionTopicTag=" + questionTopicTag +
                ", questionDifficultyTag=" + questionDifficultyTag +
                '}';
    }
}
