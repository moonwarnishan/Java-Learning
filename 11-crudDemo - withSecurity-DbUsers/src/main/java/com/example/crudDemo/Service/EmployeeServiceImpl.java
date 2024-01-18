package com.example.crudDemo.Service;

//import com.example.crudDemo.dao.EmployeeDAO;
import com.example.crudDemo.Exceptions.EmployeeAlreadyExistException;
import com.example.crudDemo.Exceptions.EmployeeNotFoundException;
import com.example.crudDemo.dao.EmployeeRepository;
import com.example.crudDemo.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.rmi.AlreadyBoundException;
import java.util.List;
import java.util.Optional;

/* @Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getById(int employeeId) {
        return employeeDAO.getById(employeeId);
    }

    @Override
    public void add(Employee employee) {
        employeeDAO.add(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    public void delete(int id) {
    employeeDAO.delete(id);
    }
}*/
//@Service
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getById(int employeeId) {
        Optional<Employee> emp = employeeRepository.findById(employeeId);
        if(emp.isEmpty())
        {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        return emp;
    }

    @Override
    public void add(Employee employee) {
        Optional<Employee> emp = employeeRepository.findByEmail(employee.getEmail());
        if(emp.isEmpty())
        {
            employeeRepository.save(employee);
        }
        throw new EmployeeAlreadyExistException("Employee With this email already Exist");
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        var emp = getById(id);
        if(emp.isEmpty())
        {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        emp.ifPresent(employeeRepository::delete);
    }
}
