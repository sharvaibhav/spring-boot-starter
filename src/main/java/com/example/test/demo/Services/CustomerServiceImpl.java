package com.example.test.demo.Services;

import com.example.test.demo.Beans.CustomerDto;
import com.example.test.demo.entity.Customer;
import com.example.test.demo.repositories.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public Customer getCustomerWithId(int customerId) {
    return customerRepository.findByCustomerId(customerId);
  }

  @Override
  public Customer getCustomerWithName(String name) {
    List<Customer> allByName = customerRepository.findAllByName(name);
    return allByName.get(0);
  }


  @Override
  public List<Customer> getAllCustomers() {
    ArrayList<Customer> customerDtos = new ArrayList<>();
    List<Customer> allCustomers = customerRepository.findAllByName("Gagan");
    customerDtos.addAll(allCustomers);
    return customerDtos;

  }

  @Override
  public Customer createCustomer(Customer customer) {
    return customerRepository.save(customer);
  }
}
