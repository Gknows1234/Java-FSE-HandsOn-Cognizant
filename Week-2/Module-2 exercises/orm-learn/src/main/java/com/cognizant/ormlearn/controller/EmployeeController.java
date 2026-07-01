package com.cognizant.ormlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;

/**
 * REST controller that exposes employee-related endpoints.
 * All URLs are prefixed with /api for clarity.
 *
 * Test these endpoints in Postman:
 *   GET http://localhost:8080/api/employees
 *   GET http://localhost:8080/api/employees/{id}
 *   GET http://localhost:8080/api/employees/department/{deptId}
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    /** Returns the complete list of employees. */
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        LOGGER.info("GET /api/employees invoked");
        List<Employee> employees = employeeService.getAllEmployees();
        LOGGER.debug("Returning {} employees", employees.size());
        return employees;
    }

    /** Returns a single employee by id. */
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        LOGGER.info("GET /api/employees/{} invoked", id);
        return employeeService.findEmployeeById(id);
    }

    /** Returns employees belonging to a particular department. */
    @GetMapping("/employees/department/{deptId}")
    public List<Employee> getEmployeesByDepartment(@PathVariable int deptId) {
        LOGGER.info("GET /api/employees/department/{} invoked", deptId);
        return employeeService.findByDepartmentId(deptId);
    }

    /** Returns all employees sorted by salary descending. */
    @GetMapping("/employees/sorted-by-salary")
    public List<Employee> getEmployeesSortedBySalary() {
        LOGGER.info("GET /api/employees/sorted-by-salary invoked");
        return employeeService.findAllSortedBySalaryDesc();
    }
}
