package com.ken.app.test.mvc.crud.dao;

import com.ken.app.test.mvc.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // That's it ... no need to write any code.

    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}

