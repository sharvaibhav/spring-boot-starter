package com.example.test.demo.controllers;

import com.example.test.demo.Beans.CustomerDto;
import com.example.test.demo.Services.CustomerService;
import com.example.test.demo.entity.Customer;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
   * @param id
   * @return
   */
  @GetMapping(value = "/{id}")
  public CustomerDto findCustomerWithId(@PathVariable int id) {

    Customer customerWithId = customerService.getCustomerWithId(id);
    CustomerDto customerDto = convertToDto(customerWithId);
    return customerDto;
  }

  /**
   *
   * @return
   */
  @GetMapping
  public List<CustomerDto> findAllCustomers() {
    List<Customer> allCustomerDtos = customerService.getAllCustomers();
    List<CustomerDto> collect = allCustomerDtos.stream().map(this::convertToDto).collect(Collectors.toList());
    return collect;
  }

/*
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Long create(@RequestBody Foo resource) {
    Preconditions.checkNotNull(resource);
    return service.create(resource);
  }*/

  /**
   * This function will convert the entity to DTO
   * @param customer
   * @return
   */
  private CustomerDto convertToDto(Customer customer) {
  CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
  return customerDto;
}
}