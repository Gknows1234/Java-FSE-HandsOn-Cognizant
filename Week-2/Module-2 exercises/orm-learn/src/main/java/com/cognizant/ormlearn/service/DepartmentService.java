package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.repository.DepartmentRepository;

/**
 * Service layer for Department operations.
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    /** Returns every department in the database. */
    @Transactional
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    /** Finds a single department by its primary key. */
    @Transactional
    public Department findDepartmentById(int id) {
        Optional<Department> result = departmentRepository.findById(id);
        return result.orElse(null);
    }

    /** Persists a new department or updates an existing one. */
    @Transactional
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    /** Removes a department by id. */
    @Transactional
    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }
}
