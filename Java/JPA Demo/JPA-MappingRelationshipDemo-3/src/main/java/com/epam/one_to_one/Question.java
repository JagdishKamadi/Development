package com.epam.one_to_one;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @Column(name = "question_id")
    private int  questionNo;
    private String question;
    @OneToOne
    private Answer answer;

    public Question() {
    }

    public Question(int questionNo, String question, Answer answer) {
        this.questionNo = questionNo;
        this.question = question;
        this.answer = answer;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
