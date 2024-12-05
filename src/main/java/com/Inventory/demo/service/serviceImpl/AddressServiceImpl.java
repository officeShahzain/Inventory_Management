package com.Inventory.demo.service.serviceImpl;

import com.Inventory.demo.ResponseEntity.CustomResponseEntity;
import com.Inventory.demo.generic.GenericDao;
import com.Inventory.demo.model.entity.Address;
import com.Inventory.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    GenericDao<Address> addressGenericDao;
    @Override
    public CustomResponseEntity addAddress(Address address) {
        if(address == null){
            return CustomResponseEntity.error("Invalid Address");
        }
        Address addAddress = addressGenericDao.saveOrUpdate(address);
        return new CustomResponseEntity<>(addAddress,"Success");
    }

    @Override
    public CustomResponseEntity getAddress(Long id) {
        Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        String jpql = "select a from address a where a.id = :id";
        Address address = addressGenericDao.findOneWithQuery(jpql, param);
        return new CustomResponseEntity(address, "Success");
    }
}
