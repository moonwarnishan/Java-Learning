/*
package com.example.crudDemo.dao;
import com.example.crudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entitymanager
    private final EntityManager entityManager;

    // set up constructor
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the result
        return employees;
    }

    @Override
    public Employee getById(int employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

    @Override
    @Transactional
    public void add(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Employee employee = getById(id);
        if( employee != null)
        {
            entityManager.remove(employee);
        }
    }
}
*/
