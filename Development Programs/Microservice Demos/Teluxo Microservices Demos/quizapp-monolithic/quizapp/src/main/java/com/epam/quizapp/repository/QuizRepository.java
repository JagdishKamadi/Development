package com.epam.quizapp.repository;

import com.epam.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

    Quiz findByQuizTitle(String quizTitle);
}
