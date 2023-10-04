package com.epam.quiz.repository;

import java.util.List;

import com.epam.quiz.model.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> {
    List<AuthGroup> findByUsername(String username);
}