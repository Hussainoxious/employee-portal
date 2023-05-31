package com.example.employeeportal.repository;

import com.example.employeeportal.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByDesignation(String designation);
    List<Employee> findByLocation(String location);
    List<Employee> findByEmployeeRating(float employeeRating);
    List<Employee> findByPractice(String practice);
//    @Query(value = "Select * from employee_details e where e.designation=?1 and e.location=?2 and e.employee_rating=?3 and e.practice=?4", nativeQuery=true)
//    List<Employee> findByFields(String designation, String location, float employeeRating, String practice);
    List<Employee> findByDesignationAndLocationAndEmployeeRatingAndPractice(String designation, String location, float employeeRating, String practice);
}
