package com.spring.mvc_hibernate_aop.repository;

import com.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface IEmployeeRepository {
    public List<Employee> getAll();

    public void saveEmployee(Employee employee);

    public Employee getById(int id);

    public void deleteById(int id);
}
