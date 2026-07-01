package com.cognizant.ormlearn.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Represents an employee record.
 *
 * Demonstrates three JPA relationship annotations:
 *  - @ManyToOne  (Employee → Department)
 *  - @JoinColumn (foreign-key column in the employee table)
 *  - @ManyToMany (Employee ↔ Skill via a join table)
 *  - @JoinTable  (defines the join table and its columns)
 *  - FetchType.EAGER / FetchType.LAZY
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "em_id")
    private int id;

    @Column(name = "em_name", length = 50)
    private String name;

    @Column(name = "em_salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @Column(name = "em_date_of_joining")
    @Temporal(TemporalType.DATE)
    private Date dateOfJoining;

    /**
     * Many employees belong to one department.
     * FetchType.EAGER loads the department together with the employee
     * in a single query (useful when you always need department info).
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "em_dp_id")
    private Department department;

    /**
     * Many-to-many between Employee and Skill.
     * This is the *owning* side, so the @JoinTable is declared here.
     * FetchType.EAGER ensures skills are loaded along with the employee.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "employee_skill",
        joinColumns = @JoinColumn(name = "es_em_id"),
        inverseJoinColumns = @JoinColumn(name = "es_sk_id")
    )
    private List<Skill> skillList = new ArrayList<>();

    public Employee() {
    }

    public Employee(String name, BigDecimal salary, Date dateOfJoining) {
        this.name = name;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
    }

    // ---- accessors ----

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id
                + ", name=" + name
                + ", salary=" + salary
                + ", dateOfJoining=" + dateOfJoining
                + ", department=" + (department != null ? department.getName() : "N/A")
                + ", skills=" + skillList
                + "]";
    }
}
