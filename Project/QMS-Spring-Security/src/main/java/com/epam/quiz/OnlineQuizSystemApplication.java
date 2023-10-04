package com.epam.quiz;

import com.epam.quiz.model.AuthGroup;
import com.epam.quiz.model.User;
import com.epam.quiz.repository.AuthGroupRepository;
import com.epam.quiz.repository.UserRepository;
import com.epam.quiz.utility.cls.Welcome;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Quiz Management System",
								description = "Sample quiz application using spring rest",
								version = "1.0",
				contact = @Contact(
								name  = "Jagdish Kamadi",
								email = "jagdish_kamadi@epam.com")))

public class OnlineQuizSystemApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthGroupRepository authGroupRepository;
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OnlineQuizSystemApplication.class, args);

		Welcome welcome = context.getBean(Welcome.class);
		welcome.helloAdmin();
	}

	@Override
	public void run(String... args) throws Exception {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		User user1 = new User("Jagdish","jagadishkamadi@gmail.com",encoder.encode("Jagdish@99"),2,true);
//		User user2 = new User("Admin","admin@gmail.com",encoder.encode("Admin@00"),1,true);
//
//		userRepository.save(user1);
//		userRepository.save(user2);
//
//		AuthGroup authGroup1 = new AuthGroup();
//		authGroup1.setAuthGroup("USER");
//		authGroup1.setUsername("Jagdish");
//
//		AuthGroup authGroup2 = new AuthGroup();
//		authGroup2.setAuthGroup("ADMIN");
//		authGroup2.setUsername("Admin");
//
//		authGroupRepository.save(authGroup1);
//		authGroupRepository.save(authGroup2);
	}
}
