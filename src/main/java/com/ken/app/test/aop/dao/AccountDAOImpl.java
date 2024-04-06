package com.ken.app.test.aop.dao;

import com.ken.app.test.aop.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account theAccount) {
        System.out.println(getClass() + ": Doing my DB WORK: Adding an account");
    }

    @Override
    public String getName() {
        System.out.println(getClass() + " : getName");
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println(getClass() + " : setName");
        this.name = name;
    }

    @Override
    public String getServiceCode() {
        System.out.println(getClass() + " : getServiceCode");
        return serviceCode;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : setServiceCode");
        this.serviceCode = serviceCode;
    }
}
