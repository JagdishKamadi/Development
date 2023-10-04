package com.epam.quiz.dto;

import com.epam.quiz.model.Section;
import com.epam.quiz.utility.enm.SectionTag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

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
}
