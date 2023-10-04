package com.epam.quiz.model;

import com.epam.quiz.utility.enm.DifficultyTag;
import com.epam.quiz.utility.enm.TopicTag;

import javax.persistence.*;

@Entity
public class Section {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionTagId;


    @Enumerated(EnumType.STRING)
    private TopicTag topicTag;

    @Enumerated(EnumType.STRING)
    private DifficultyTag difficultyTag;


    public Section() {
    }

    public Section(TopicTag topicTag, DifficultyTag difficultyTag) {
        this.topicTag = topicTag;
        this.difficultyTag = difficultyTag;
    }

    public int getQuestionTagId() {
        return questionTagId;
    }

    public void setQuestionTagId(int questionTagId) {
        this.questionTagId = questionTagId;
    }

    public TopicTag getTopicTag() {
        return topicTag;
    }

    public void setTopicTag(TopicTag topicTag) {
        this.topicTag = topicTag;
    }

    public DifficultyTag getDifficultyTag() {
        return difficultyTag;
    }

    public void setDifficultyTag(DifficultyTag difficultyTag) {
        this.difficultyTag = difficultyTag;
    }

    @Override
    public String toString() {
        return "Section{" +
                "questionTagId=" + questionTagId +
                ", topicTag=" + topicTag +
                ", difficultyTag=" + difficultyTag +
                '}';
    }
}
