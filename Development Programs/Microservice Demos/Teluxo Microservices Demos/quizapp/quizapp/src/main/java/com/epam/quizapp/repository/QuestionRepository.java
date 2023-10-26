package com.epam.quizapp.repository;

import com.epam.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    List<Question> findByCategoryAndLevel(String category, String level);
}
