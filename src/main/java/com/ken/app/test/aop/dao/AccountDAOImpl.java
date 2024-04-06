package com.ken.app.test.aop.dao;

import com.ken.app.test.aop.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount(Account theAccount) {
        System.out.println(getClass() + ": Doing my DB WORK: Adding an account");
    }
}
