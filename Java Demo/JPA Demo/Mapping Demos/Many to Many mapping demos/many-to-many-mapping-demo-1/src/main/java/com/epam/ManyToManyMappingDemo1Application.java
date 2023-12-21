package com.epam;

import com.epam.entity.Post;
import com.epam.entity.Tag;
import com.epam.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ManyToManyMappingDemo1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyMappingDemo1Application.class, args);
	}

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		Post p1 = Post.builder()
				.postDescription("ICC t-20 World Cup!")
				.build();

		Post p2 = Post.builder()
				.postDescription("IPl season-15")
				.build();

		Tag t1 = Tag.builder()
				.tagDescription("It's a great world cup")
				.build();

		Tag t2 = Tag.builder()
				.tagDescription("Something big will happen this time")
				.build();

		List<Tag> tagList = new ArrayList<>();
		tagList.add(t1);
		tagList.add(t2);

		p2.setTags(tagList);
		p1.setTags(tagList);


		List<Post> postList = new ArrayList<>();
		postList.add(p1);
		t1.setPosts(postList);

		postRepository.save(p1);
		postRepository.save(p2);
	}
}
