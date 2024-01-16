package com.example.crudDemo.dao;
import com.example.crudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "emp")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
