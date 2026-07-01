package com.cognizant.ormlearn.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Employee;

/**
 * Repository for the Employee entity.
 * Combines derived query methods with HQL/JPQL and native SQL examples.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // -------------------------------------------------------------------
    //  DERIVED QUERY METHODS
    // -------------------------------------------------------------------

    /** Employees in a specific department (by department id). */
    List<Employee> findByDepartmentId(int departmentId);

    /** Employees whose name contains the given text. */
    List<Employee> findByNameContaining(String keyword);

    /** Employees earning more than the specified amount. */
    List<Employee> findBySalaryGreaterThan(BigDecimal amount);

    /** Employees earning less than the specified amount. */
    List<Employee> findBySalaryLessThan(BigDecimal amount);

    /** Employees who joined between two dates. */
    List<Employee> findByDateOfJoiningBetween(Date startDate, Date endDate);

    /** Sorted by salary descending. */
    List<Employee> findAllByOrderBySalaryDesc();

    // -------------------------------------------------------------------
    //  JPQL / HQL QUERIES
    // -------------------------------------------------------------------

    /**
     * HQL with fetch keyword: loads Department eagerly in a single query
     * even if the mapping is LAZY.
     */
    @Query("SELECT e FROM Employee e JOIN FETCH e.department WHERE e.id = :empId")
    Employee findByIdWithDepartment(@Param("empId") int empId);

    /**
     * JPQL aggregate: average salary of all employees.
     */
    @Query("SELECT AVG(e.salary) FROM Employee e")
    BigDecimal findAverageSalary();

    /**
     * JPQL aggregate: maximum salary across all employees.
     */
    @Query("SELECT MAX(e.salary) FROM Employee e")
    BigDecimal findMaxSalary();

    /**
     * JPQL aggregate: minimum salary across all employees.
     */
    @Query("SELECT MIN(e.salary) FROM Employee e")
    BigDecimal findMinSalary();

    /**
     * JPQL: employees in a department identified by name.
     */
    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findByDepartmentName(@Param("deptName") String departmentName);

    // -------------------------------------------------------------------
    //  NATIVE SQL QUERIES
    // -------------------------------------------------------------------

    /**
     * Native query that returns employees ordered by joining date.
     */
    @Query(value = "SELECT * FROM employee ORDER BY em_date_of_joining ASC",
           nativeQuery = true)
    List<Employee> findAllSortedByJoiningDateNative();

    /**
     * Native aggregate: total salary expenditure across all employees.
     */
    @Query(value = "SELECT SUM(em_salary) FROM employee", nativeQuery = true)
    BigDecimal findTotalSalaryNative();
}
