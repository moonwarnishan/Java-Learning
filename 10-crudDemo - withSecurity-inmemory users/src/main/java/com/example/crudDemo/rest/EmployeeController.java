package com.example.crudDemo.rest;

import com.example.crudDemo.Service.EmployeeService;
import com.example.crudDemo.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id") int id) {
        return employeeService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.delete(id);
    }

    @PostMapping
    public void add(@RequestBody Employee employee) {
        employeeService.add(employee);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Employee employee) {
        // Assuming you want to update an existing employee with the given ID
        employee.setId(id);
        employeeService.update(employee);
    }
}

