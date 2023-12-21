package com.epam;

import com.epam.entities.Product;
import com.epam.repositories.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Random;


@SpringBootApplication
public class SpringDataPaginationDemo1Application implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(SpringDataPaginationDemo1Application.class);
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataPaginationDemo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Random random  = new Random();

		Sort sort = Sort.by("price").descending();
		Pageable pageable = PageRequest.of(5,30,sort);
		Page<Product> page = productRepository.findAll(pageable);
		List<Product> productList = page.getContent();

		productList.stream().forEach(product -> System.out.println(product+"\n"));
	}
}
