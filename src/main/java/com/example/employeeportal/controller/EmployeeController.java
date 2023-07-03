package com.example.employeeportal.controller;

import com.example.employeeportal.entity.Employee;
import com.example.employeeportal.service.EmployeeService;
import com.example.employeeportal.exception.InvalidRequestException;
import com.example.employeeportal.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        try {
            Employee savedEmployee = employeeService.saveEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
        } catch (Exception exception) {
            throw new InvalidRequestException("Failed to save employee.", exception);
        }
    }

    @GetMapping(value = "/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            return ResponseEntity.status(HttpStatus.OK).body(employees);
        } catch (Exception exception) {
            throw new InvalidRequestException("Failed to retrieve employees.", exception);
        }
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<Employee>> searchEmployees(@RequestParam(required = false) String designation,
                                                          @RequestParam(required = false) String location,
                                                          @RequestParam(required = false) Float employeeRating,
                                                          @RequestParam(required = false) String practice) {
        try {
            List<Employee> employees = employeeService.searchEmployees(designation, location, employeeRating, practice);
            return ResponseEntity.status(HttpStatus.OK).body(employees);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<String> handleInvalidRequestException(InvalidRequestException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}