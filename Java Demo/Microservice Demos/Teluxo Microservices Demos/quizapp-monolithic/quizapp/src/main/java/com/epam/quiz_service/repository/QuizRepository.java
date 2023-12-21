package com.epam.quiz_service.repository;

import com.epam.quiz_service.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

    Quiz findByQuizTitle(String quizTitle);
}
