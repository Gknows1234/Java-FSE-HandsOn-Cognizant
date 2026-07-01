package com.cognizant.ormlearn.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;

/**
 * Service layer for Employee operations.
 * Wraps repository calls inside Spring-managed transactions.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /** Returns every employee stored in the database. */
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /** Looks up a single employee by primary key. */
    @Transactional
    public Employee findEmployeeById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        return result.orElse(null);
    }

    /** Persists a new employee or updates an existing one. */
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /** Removes an employee by id. */
    @Transactional
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    /** Employees belonging to a specific department. */
    @Transactional
    public List<Employee> findByDepartmentId(int departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    /** Employees whose name contains the keyword. */
    @Transactional
    public List<Employee> findByNameContaining(String keyword) {
        return employeeRepository.findByNameContaining(keyword);
    }

    /** Employees earning above the given threshold. */
    @Transactional
    public List<Employee> findBySalaryGreaterThan(BigDecimal amount) {
        return employeeRepository.findBySalaryGreaterThan(amount);
    }

    /** Employees earning below the given threshold. */
    @Transactional
    public List<Employee> findBySalaryLessThan(BigDecimal amount) {
        return employeeRepository.findBySalaryLessThan(amount);
    }

    /** Employees who joined between two dates (inclusive). */
    @Transactional
    public List<Employee> findByDateOfJoiningBetween(Date start, Date end) {
        return employeeRepository.findByDateOfJoiningBetween(start, end);
    }

    /** All employees ordered by salary highest-first. */
    @Transactional
    public List<Employee> findAllSortedBySalaryDesc() {
        return employeeRepository.findAllByOrderBySalaryDesc();
    }

    /** Fetches a single employee along with its department (HQL fetch join). */
    @Transactional
    public Employee findByIdWithDepartment(int id) {
        return employeeRepository.findByIdWithDepartment(id);
    }

    /** Average salary computed via JPQL aggregate. */
    @Transactional
    public BigDecimal getAverageSalary() {
        return employeeRepository.findAverageSalary();
    }

    /** Maximum salary via JPQL aggregate. */
    @Transactional
    public BigDecimal getMaxSalary() {
        return employeeRepository.findMaxSalary();
    }

    /** Minimum salary via JPQL aggregate. */
    @Transactional
    public BigDecimal getMinSalary() {
        return employeeRepository.findMinSalary();
    }

    /** Employees in a department identified by department name (JPQL). */
    @Transactional
    public List<Employee> findByDepartmentName(String deptName) {
        return employeeRepository.findByDepartmentName(deptName);
    }

    /** All employees sorted by joining date using native SQL. */
    @Transactional
    public List<Employee> findAllSortedByJoiningDateNative() {
        return employeeRepository.findAllSortedByJoiningDateNative();
    }

    /** Total salary expenditure using native SQL aggregate. */
    @Transactional
    public BigDecimal getTotalSalaryNative() {
        return employeeRepository.findTotalSalaryNative();
    }
}
