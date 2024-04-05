package com.ken.app.test.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addMember() {
        System.out.println(getClass() + ": Doing my DB WORK: Adding a Membership Account");
    }
}
