package com.epam.quiz.model;


import com.epam.quiz.utility.enm.SectionTag;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@DynamicUpdate
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;

    @NotNull
	@Size(min = 10,message = "Enter valid question description")
    private String questionDescription;

    @NotNull
	@Size(min = 1,message = "Option have at least one value")
    private String option1;
    
    @NotNull
	@Size(min = 1,message = "Option have at least one value")
    private String option2;
    
    private String option3;
    private String option4;
    
	@NotNull
	@Size(max = 1,message = "Option have at least one value")
    private String answer;

	@NotNull
	@Enumerated(EnumType.STRING)
	private SectionTag sectionTag;

	@NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Section section;
	public Question() {

	}

	public Question(String questionDescription, String option1, String option2, String option3, String option4, String answer) {
		this.questionDescription = questionDescription;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
	}

	public SectionTag getSectionTag() {
		return sectionTag;
	}

	public void setSectionTag(SectionTag sectionTag) {
		this.sectionTag = sectionTag;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
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

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "Question{" +
				"questionId=" + questionId +
				", questionDescription='" + questionDescription + '\'' +
				", option1='" + option1 + '\'' +
				", option2='" + option2 + '\'' +
				", option3='" + option3 + '\'' +
				", option4='" + option4 + '\'' +
				", answer='" + answer + '\'' +
				", section=" + section +
				'}';
	}
}
