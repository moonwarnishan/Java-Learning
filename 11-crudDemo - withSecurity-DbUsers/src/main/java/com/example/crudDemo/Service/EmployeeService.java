package com.example.crudDemo.Service;

import com.example.crudDemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> getById(int employeeId);

    void add(Employee employee);
    void update(Employee employee);
    void delete(int id);
}
