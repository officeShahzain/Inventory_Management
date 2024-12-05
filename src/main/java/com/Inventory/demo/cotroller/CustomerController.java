package com.Inventory.demo.cotroller;

import com.Inventory.demo.ResponseEntity.CustomResponseEntity;
import com.Inventory.demo.model.dto.CustomerDto;
import com.Inventory.demo.model.entity.Customer;
import com.Inventory.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public CustomResponseEntity addNewCustomer(Customer customerDto){
        return customerService.addNewCustomer(customerDto);
    }

    @GetMapping("/fetchAll")
    public CustomResponseEntity fetchAll(CustomerDto customerDto){
        return customerService.fetchAllCustomer(customerDto);
    }
    @GetMapping("/fetchSpecific")
    public CustomResponseEntity fetchSpecific(CustomerDto customerDto){
        return customerService.fetchSpecificCustomer(customerDto);
    }
}
