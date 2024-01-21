package com.epam;

import com.epam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epam.model.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityDemoApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//		User user1 = new User("Jagdish","jagdish@gmail.com",encoder.encode("Jagdish@99"),"USER");
//		User user2 = new User("Admin","admin@gmail.com",encoder.encode("Admin@00"),"ADMIN");
//
//		userRepository.save(user1);
//		userRepository.save(user2);
	}
}
