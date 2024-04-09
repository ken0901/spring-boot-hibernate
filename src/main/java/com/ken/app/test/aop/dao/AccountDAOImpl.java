package com.ken.app.test.aop.dao;

import com.ken.app.test.aop.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account theAccount) {
        System.out.println(getClass() + ": Doing my DB WORK: Adding an account");
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // for academic purposes ... simulate an exception
        if(tripWire){
            throw new RuntimeException("No soup for you!");
        }

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account tmp1 = new Account("John", "Silver");
        Account tmp2 = new Account("Ken", "Platinum");
        Account tmp3 = new Account("Katie", "Gold");

        // add them to our accounts list
        myAccounts.add(tmp1);
        myAccounts.add(tmp2);
        myAccounts.add(tmp3);

        return myAccounts;
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
