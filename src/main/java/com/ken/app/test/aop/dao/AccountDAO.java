package com.ken.app.test.aop.dao;

import com.ken.app.test.aop.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account theAccount);

    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);
}
