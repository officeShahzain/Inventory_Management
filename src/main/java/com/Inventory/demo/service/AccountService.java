package com.Inventory.demo.service;

import com.Inventory.demo.ResponseEntity.CustomResponseEntity;
import com.Inventory.demo.model.entity.Account;
import com.Inventory.demo.model.entity.Customer;

public interface AccountService {
    public CustomResponseEntity addAccount(Account account);
    public CustomResponseEntity getAccount(Long id);
}
