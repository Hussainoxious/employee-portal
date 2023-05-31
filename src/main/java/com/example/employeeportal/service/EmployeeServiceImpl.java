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
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    @Override
    public List<Employee> getByDesignation(String designation) {
        return employeeRepository.findByDesignation(designation);
    }
    @Override
    public List<Employee> getByLocation(String location) {
        return employeeRepository.findByLocation(location);
    }
    @Override
    public List<Employee> getByEmployeeRating(float employeeRating) {
        return employeeRepository.findByEmployeeRating(employeeRating);
    }
    @Override
    public List<Employee> getByPractice(String practice) {
        return employeeRepository.findByPractice(practice);
    }
//    @Override
//    public List<Employee> getFromEverything(Employee employee) {
//        return employeeRepository.findByFields(employee.getDesignation(), employee.getLocation(), employee.getEmployeeRating(), employee.getPractice());
//    }
    @Override
    public List<Employee> searchEmployees(String designation, String location, Float employeeRating, String practice) {
        return employeeRepository.findByDesignationAndLocationAndEmployeeRatingAndPractice(designation, location, employeeRating, practice);
    }
}
