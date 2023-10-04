
package com.epam.quiz.repository;

import com.epam.quiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.username=?1 and u.password=?2 ")
	public Optional<User> findByUsernameAndPassword(String username, String password);

	@Query("SELECT COUNT(u) FROM User u WHERE u.username=?1 or u.mailId =?2")
	public Integer findByUsernameOrMailid(String username,String mailId);

	Optional<User> findByUsername(String username);
}
