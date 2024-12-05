package com.Inventory.demo.service.serviceImpl;

import com.Inventory.demo.ResponseEntity.CustomResponseEntity;
import com.Inventory.demo.generic.GenericDao;
import com.Inventory.demo.model.entity.Account;
import com.Inventory.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AccountServiceImpl implements AccountService {
    @Autowired
    GenericDao<Account> accountGenericDao;
    @Override
    public CustomResponseEntity addAccount(Account account) {
        String jpql;
        Map<String, Object> param = new HashMap<>();
        param.put("accountNumber", account.getAccountNumber());
        jpql = "Select ac from Account ac where ac.accountNumber = :accountNumber";
        Account addNewAccount = accountGenericDao.findOneWithQuery(jpql, param);
        if (addNewAccount == null){
            Account newAccount = new Account();
            newAccount.setAccountNumber(account.getAccountNumber());
            newAccount.setBalance(100.0);
            newAccount.setCredit(1000.0);
            newAccount.setDebit(500.0);
            Account a = accountGenericDao.saveOrUpdate(newAccount);
            return new CustomResponseEntity(a, "Success");
        }
        return CustomResponseEntity.error("Invalid Account");
    }

    @Override
    public CustomResponseEntity getAccount(Long id) {
        String jpql;
        Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        return null;
    }
}
