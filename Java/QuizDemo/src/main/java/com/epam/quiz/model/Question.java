package com.epam.quiz.model;

import javax.persistence.CascadeType;
import javax.persistence.*;


@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;
    private  String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private String sectionName;
    @OneToOne(cascade = CascadeType.ALL)
    private QuestionTag questionTag;

    public Question() {
    }

    public Question(String question, String option1, String option2, String option3, String option4, String answer, String sectionName, QuestionTag questionTag) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.sectionName = sectionName;
        this.questionTag = questionTag;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public QuestionTag getQuestionTag() {
        return questionTag;
    }

    public void setQuestionTag(QuestionTag questionTag) {
        this.questionTag = questionTag;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", answer='" + answer + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", questionTag=" + questionTag +
                '}';
    }
}
