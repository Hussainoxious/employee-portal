package com.example.employeeportal.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee_details")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String employeeName;
    private String location;
    private String practice;
    private String designation;
    private float employeeRating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public float getEmployeeRating() {
        return employeeRating;
    }

    public void setEmployeeRating(float employeeRating) {
        this.employeeRating = employeeRating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
