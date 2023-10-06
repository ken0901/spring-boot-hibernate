package com.ken.app.test.api.dao;

import com.ken.app.test.api.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
