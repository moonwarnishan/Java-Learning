package com.example.crudDemo.Exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message)
    {
        super(message);
    }
}
