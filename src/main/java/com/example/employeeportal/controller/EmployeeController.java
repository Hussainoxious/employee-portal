package com.example.employeeportal.controller;

import com.example.employeeportal.entity.Employee;
import com.example.employeeportal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/save")
    ResponseEntity saveEmployee(@RequestBody Employee employee) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employee));
        } catch (Exception exception) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/getAll")
    ResponseEntity getEmployees() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployees());
        } catch (Exception exception) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/designation/{designation}")
    ResponseEntity getByDesignation(@PathVariable String designation) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByDesignation(designation));
        } catch (Exception exception) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/location/{location}")
    ResponseEntity getByLocation(@PathVariable String location) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByLocation(location));
        } catch (Exception exception) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/rating/{employeeRating}")
    ResponseEntity getByEmployeeRating(@PathVariable float employeeRating) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByEmployeeRating(employeeRating));
        } catch (Exception exception) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/practice/{practice}")
    ResponseEntity getByPractice(@PathVariable String practice) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByPractice(practice));
        } catch (Exception exception) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @PostMapping(value = "/fields")
//    ResponseEntity getByQuery(@RequestBody Employee employee) {
//        try {
//            return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.getFromEverything(employee));
//        } catch (Exception exception) {
//            return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    @GetMapping(value = "/search")
    ResponseEntity searchEmployees(
            @RequestParam(required = false) String designation,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Float employeeRating,
            @RequestParam(required = false) String practice
    ) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.searchEmployees(designation, location, employeeRating, practice));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}