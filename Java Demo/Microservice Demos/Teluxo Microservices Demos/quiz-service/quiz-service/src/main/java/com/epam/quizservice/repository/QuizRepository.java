package com.epam.quizservice.repository;


import com.epam.quizservice.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

    Quiz findByQuizTitle(String quizTitle);
}
