package com.epam.questionservice.repository;

import com.epam.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    List<Question> findByCategoryAndLevel(String category, String level);

    /**
     * For postgres
     * RANDOM()
     */
    @Query(value = "SELECT q.id FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numberOfQuestions", nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String category, Integer numberOfQuestions);
}
