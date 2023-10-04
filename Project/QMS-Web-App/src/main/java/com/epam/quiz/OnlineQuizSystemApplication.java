package com.epam.quiz;

import com.epam.quiz.model.User;
import com.epam.quiz.repository.UserRepository;
import com.epam.quiz.utility.cls.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OnlineQuizSystemApplication implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OnlineQuizSystemApplication.class, args);
		Greeting greeting = context.getBean(Greeting.class);
		greeting.sayWelcome("Jagdish");
	}

	@Override
	public void run(String... args) throws Exception {

		PasswordEncoder encoder = new BCryptPasswordEncoder();
//		User user1 = new User();
//		user1.setUsername("Jagdish");
//		user1.setMailId("jagadishkamadi@gmail.com");
//		user1.setPassword(encoder.encode("Jagdish@99"));
//		user1.setTypeOfUser(2);
//
//		User user2 = new User();
//		user2.setUsername("Admin");
//		user2.setMailId("admin@gmail.com");
//		user2.setPassword(encoder.encode("Admin@00"));
//		user2.setTypeOfUser(1);
//
//		userRepository.save(user1);
//		userRepository.save(user2);
	}
}
