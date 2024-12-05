package com.Inventory.demo.service;

import com.Inventory.demo.ResponseEntity.CustomResponseEntity;
import com.Inventory.demo.model.dto.CustomerDto;
import com.Inventory.demo.model.entity.Customer;

public interface CustomerService {
    public CustomResponseEntity addNewCustomer(Customer customerDto);
    public CustomResponseEntity fetchSpecificCustomer(CustomerDto customerDto);
    public CustomResponseEntity fetchAllCustomer(CustomerDto customerDto);
}
