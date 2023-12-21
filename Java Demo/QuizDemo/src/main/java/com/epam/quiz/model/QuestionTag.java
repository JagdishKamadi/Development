package com.epam.quiz.model;

import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;

import javax.persistence.*;

@Entity
public class QuestionTag {
    @Id
    private int questionTagId;
    @Enumerated(EnumType.STRING)
    private QuestionTopicTag questionTopicTag;

    @Enumerated(EnumType.STRING)
    private QuestionDifficultyTag questionDifficultyTag;



    public QuestionTag() {
    }

    public QuestionTag(int questionTagId, QuestionTopicTag questionTopicTag, QuestionDifficultyTag questionDifficultyTag) {
        this.questionTagId = questionTagId;
        this.questionTopicTag = questionTopicTag;
        this.questionDifficultyTag = questionDifficultyTag;

    }

    public int getQuestionTagId() {
        return questionTagId;
    }

    public void setQuestionTagId(int questionTagId) {
        this.questionTagId = questionTagId;
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
                "questionId=" + questionTagId +
                ", questionTopicTag=" + questionTopicTag +
                ", questionDifficultyTag=" + questionDifficultyTag +
                '}';
    }
}
