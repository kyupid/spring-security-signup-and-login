package com.example.demo;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    int insert(Employee employee);

    Employee getById(int id);
}
