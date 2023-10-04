package com.epam.quiz.repository;

import com.epam.quiz.model.Question;
import com.epam.quiz.utility.enm.SectionTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findBySectionTag(SectionTag sectionTag);
}
