package com.ken.app.test.api.dao;

import com.ken.app.test.api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // That's it ... no need to write any code.
}

