package com.epam.onetomanymappingdemo1.repository;

import com.epam.onetomanymappingdemo1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
