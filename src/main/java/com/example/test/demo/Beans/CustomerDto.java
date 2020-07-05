package com.example.test.demo.Beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
  private int customerId;
  private String passportNumber;
  private String name;
  private String flightNumber;
  private String gender;
  private int age;

  public CustomerDto(int customerId) {
    this.customerId = customerId;
  }
}
