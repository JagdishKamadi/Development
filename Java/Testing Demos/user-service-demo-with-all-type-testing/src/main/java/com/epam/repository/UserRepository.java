package com.epam.repository;

import com.epam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Integer countById(Integer userId);

    Optional<User> findByUsername(String username);

    void deleteByUsername(String username);

    @Query(value = "SELECT COUNT(u) FROM User u WHERE u.username =?1")
    Integer getCountByUsername(String username);
}

