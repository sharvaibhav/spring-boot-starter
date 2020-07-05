package com.example.test.demo.Services;

import com.example.test.demo.entity.Customer;
import java.util.List;

public interface CustomerService {

  public Customer getCustomerWithId(int customerId);

  public List<Customer> getAllCustomers();

}
