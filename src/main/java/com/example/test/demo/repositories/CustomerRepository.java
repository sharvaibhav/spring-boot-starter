package com.example.test.demo.repositories;

import com.example.test.demo.entity.Customer;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findAllByName(String name);

  Customer findByCustomerId(int id);
}