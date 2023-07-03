package com.example.employeeportal.service;

import com.example.employeeportal.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    List<Employee> searchEmployees(String designation, String location, Float employeeRating, String practice);
}
