package com.Inventory.demo.service;

import com.Inventory.demo.ResponseEntity.CustomResponseEntity;
import com.Inventory.demo.model.entity.Address;

public interface AddressService {
    public CustomResponseEntity addAddress(Address address);
    public CustomResponseEntity getAddress(Long id);
}
