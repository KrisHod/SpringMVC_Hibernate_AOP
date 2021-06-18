package com.spring.mvc_hibernate_aop.service;

import com.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getAll();

    public void save(Employee employee);

    public Employee getById (int id);

    public void deleteById (int id);
}
