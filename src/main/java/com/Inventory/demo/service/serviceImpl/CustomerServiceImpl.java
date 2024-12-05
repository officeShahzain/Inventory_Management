package com.Inventory.demo.service.serviceImpl;

import com.Inventory.demo.ResponseEntity.CustomResponseEntity;
import com.Inventory.demo.generic.GenericDao;
import com.Inventory.demo.model.dto.CustomerDto;
import com.Inventory.demo.model.entity.Customer;
import com.Inventory.demo.service.AccountService;
import com.Inventory.demo.service.AddressService;
import com.Inventory.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    AddressService addressService;
    @Autowired
    GenericDao<Customer> customerGenericDao;
    @Autowired
    AccountService accountService;
    String jpql;
    Map<String, Object> param = new HashMap<>();
    @Override
    public CustomResponseEntity addNewCustomer(Customer customerDto) {
        param.put("customerName", customerDto.getCustomerName());
        param.put("mobileNumber", customerDto.getMobileNumber());
        param.put("customerId", customerDto.getId());
        jpql = "Select c from Customer c where c.customerName = :customerName OR c.mobileNumber = :mobileNumber " +
                "OR c.id = :customerId ";
        Customer customer = customerGenericDao.findOneWithQuery(jpql, param);
        if(customer != null){
            return CustomResponseEntity.error("This customer is already exist ");
        }
        if (customer.getAddress() == null){
            return CustomResponseEntity.error("Address is null");
        }
        if(customer.getAccount() == null){
            return CustomResponseEntity.error("Account is null");
        }
        addressService.addAddress(customer.getAddress());
        accountService.addAccount(customer.getAccount());

        Customer addNewCustomer = customerGenericDao.saveOrUpdate(customerDto);
        return new CustomResponseEntity(addNewCustomer, "Success");
    }

    @Override
    public CustomResponseEntity fetchSpecificCustomer(CustomerDto customerDto) {
        param.put("customerName", customerDto.getCustomerName());
        param.put("mobileNumber", customerDto.getMobileNumber());
        param.put("customerId", customerDto.getId());
        jpql = "Select c from Customer c where c.id = :customerId ";
        Customer customer = customerGenericDao.findOneWithQuery(jpql, param);
        return new CustomResponseEntity<>(customer, "success");
    }

    @Override
    public CustomResponseEntity fetchAllCustomer(CustomerDto customerDto) {
        param.put("customerName", customerDto.getCustomerName());
        param.put("mobileNumber", customerDto.getMobileNumber());
        param.put("customerId", customerDto.getId());
        jpql = "Select c from Customer c where c.customerName = :customerName OR c.mobileNumber = :mobileNumber " +
                "OR c.id = :customerId ";
        List<Customer> customers = customerGenericDao.findWithQuery(jpql, param);
        return new CustomResponseEntity<>(customers, "success");
    }

}
