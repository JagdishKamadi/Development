package com.epam.quizapp.repository;

import com.epam.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    List<Question> findByCategoryAndLevel(String category, String level);

    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :numberOfQuestions", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, Integer numberOfQuestions);
}
