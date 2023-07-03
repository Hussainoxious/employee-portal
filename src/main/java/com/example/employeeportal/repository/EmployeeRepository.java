package com.example.employeeportal.repository;

import com.example.employeeportal.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE (:designation IS NULL OR e.designation = :designation) " +
            "AND (:location IS NULL OR e.location = :location) " +
            "AND (:employeeRating IS NULL OR e.employeeRating = :employeeRating) " +
            "AND (:practice IS NULL OR e.practice = :practice)")
    List<Employee> findByFields(@Param("designation") String designation,
                                @Param("location") String location,
                                @Param("employeeRating") Float employeeRating,
                                @Param("practice") String practice);
}
