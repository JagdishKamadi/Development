
package com.epam.quiz.repository;

import com.epam.quiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.username=?1 and u.password=?2 and u.typeOfUser=?3")
	public Optional<User>  findByUsernameAndPasswordAndTypeOfUser(String username,String password,Integer typeOfUser);
	
	@Query("SELECT COUNT(u) FROM User u WHERE u.username=?1 or u.mailId =?2")
	public Integer findByUsernameOrMailid(String username,String mailId);
}
