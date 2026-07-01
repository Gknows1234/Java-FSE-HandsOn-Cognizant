package com.cognizant.ormlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.service.DepartmentService;

/**
 * REST controller that exposes department-related endpoints.
 *
 * Test in Postman:
 *   GET http://localhost:8080/api/departments
 *   GET http://localhost:8080/api/departments/{id}
 */
@RestController
@RequestMapping("/api")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    /** Returns every department in the database. */
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        LOGGER.info("GET /api/departments invoked");
        List<Department> departments = departmentService.getAllDepartments();
        LOGGER.debug("Returning {} departments", departments.size());
        return departments;
    }

    /** Returns a single department by id. */
    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        LOGGER.info("GET /api/departments/{} invoked", id);
        return departmentService.findDepartmentById(id);
    }
}
