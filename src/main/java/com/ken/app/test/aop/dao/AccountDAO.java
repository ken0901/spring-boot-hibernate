package com.ken.app.test.aop.dao;

import com.ken.app.test.aop.Account;

public interface AccountDAO {

    void addAccount(Account theAccount);

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);
}
