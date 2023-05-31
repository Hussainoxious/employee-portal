package com.example.employeeportal.service;

import com.example.employeeportal.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getEmployees();
    List<Employee> getByDesignation(String designation);
    List<Employee> getByLocation(String location);
    List<Employee> getByEmployeeRating(float employeeRating);
    List<Employee> getByPractice(String practice);
//    List<Employee> getFromEverything(Employee employee);
    List<Employee> searchEmployees(String designation, String location, Float employeeRating, String practice);
}
