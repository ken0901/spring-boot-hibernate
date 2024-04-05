package com.ken.app.test.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my DB WORK: Adding an account");
    }
}
