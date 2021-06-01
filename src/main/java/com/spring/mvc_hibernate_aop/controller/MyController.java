package com.spring.mvc_hibernate_aop.controller;

import com.spring.mvc_hibernate_aop.entity.Employee;
import com.spring.mvc_hibernate_aop.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {

        List<Employee> employees = employeeService.getAll();
        model.addAttribute("allEmps", employees);
        return "all-employees";
    }

    @RequestMapping("/addEmployee")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id) {
        employeeService.deleteById(id);
        return "redirect:/";
    }
}
