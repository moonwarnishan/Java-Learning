package com.example.crudDemo.Exceptions;

public class EmployeeAlreadyExistException extends RuntimeException{
    public EmployeeAlreadyExistException(String message)
    {
        super(message);
    }
}
