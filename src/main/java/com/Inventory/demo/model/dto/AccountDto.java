package com.Inventory.demo.model.dto;


import com.Inventory.demo.model.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String CustomerName;
    private String mobileNumber;
    private CustomerDto customerDto;
}
