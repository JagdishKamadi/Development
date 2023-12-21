package com.epam.onetomanymappingdemo1;

import com.epam.onetomanymappingdemo1.model.Customer;
import com.epam.onetomanymappingdemo1.model.Product;
import com.epam.onetomanymappingdemo1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class OneToManyMappingDemo1Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	public static void main(String[] args) {
		SpringApplication.run(OneToManyMappingDemo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Product p1 = new Product();
		p1.setProductName("Mobile");
		p1.setProductPrice(10000D);

		Product p2 = new Product();
		p2.setProductName("Laptop");
		p2.setProductPrice(34000D);

		List<Product> productList = Arrays.asList(p1,p2);

		Customer customer = Customer.builder()
				.customerName("Jagdish")
				.products(productList)
				.build();

		customerRepository.save(customer);
	}
}
