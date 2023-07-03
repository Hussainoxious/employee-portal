package com.example.employeeportal.service;

import com.example.employeeportal.entity.Employee;
import com.example.employeeportal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @Override
    public List<Employee> searchEmployees(String designation, String location, Float employeeRating, String practice) {
        return employeeRepository.findByFields(designation, location, employeeRating, practice);
    }
}
