package com.example.demo;

import lombok.Data;

import java.util.List;

@Data
public class Company {
    private int id;
    private String name;
    private List<Employee> employeeList;
}
