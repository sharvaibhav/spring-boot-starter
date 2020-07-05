package com.example.test.demo.controllers;

import com.example.test.demo.Beans.CustomerDto;
import com.example.test.demo.Services.CustomerService;
import com.example.test.demo.entity.Customer;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/customer")
public class BasicInformationController {

  @Autowired
  private CustomerService customerService;

  @Autowired
  private ModelMapper modelMapper;

  /**
   *
   */
  @GetMapping(value = "/{id}")
  public CustomerDto findCustomerWithId(@PathVariable int id) {

    Customer customerWithId = customerService.getCustomerWithId(id);
    CustomerDto customerDto = convertToDto(customerWithId);
    return customerDto;
  }

  @GetMapping(value = "/name/{name}")
  public CustomerDto findCustomerWithId(@PathVariable String name) {
    Customer customerWithName = customerService.getCustomerWithName(name);
    CustomerDto customerDto = convertToDto(customerWithName);
    return customerDto;
  }

  /**
   *
   */
  @GetMapping
  public List<CustomerDto> findAllCustomers() {
    List<Customer> allCustomerDtos = customerService.getAllCustomers();
    List<CustomerDto> collect = allCustomerDtos.stream().map(this::convertToDto).collect(Collectors.toList());
    return collect;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CustomerDto createACustomer(@RequestBody CustomerDto resource) throws ParseException {
    Customer customer = convertToEntity(resource);
    Customer customer1 = customerService.createCustomer(customer);
    return convertToDto(customer1);
  }

  /**
   * This function will convert the entity to DTO
   */
  private CustomerDto convertToDto(Customer customer) {
    CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
    return customerDto;
  }

  private Customer convertToEntity(CustomerDto customerDto) throws ParseException {
    Customer post = modelMapper.map(customerDto, Customer.class);
    return post;
  }
}