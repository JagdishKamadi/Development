package com.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.epam.model.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);
    @Query("SELECT COUNT(u) FROM User u WHERE u.username =?1 OR u.mailId =?2")
    Integer findByUsernameAndMailId(String username,String mailId);

    @Modifying
    Long deleteByUsername(String username);
}
