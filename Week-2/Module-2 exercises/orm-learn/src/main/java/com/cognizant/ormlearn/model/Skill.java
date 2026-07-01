package com.cognizant.ormlearn.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represents a skill that can be possessed by multiple employees.
 *
 * Relationship: Many-to-many with Employee.
 * The Employee entity owns the join table, so Skill uses 'mappedBy'.
 */
@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sk_id")
    private int id;

    @Column(name = "sk_name", length = 50)
    private String name;

    /**
     * Inverse side of the many-to-many association.
     * 'mappedBy' points to the 'skillList' field inside the Employee entity,
     * which is the owning side and defines the @JoinTable.
     */
    @ManyToMany(mappedBy = "skillList")
    @JsonIgnore
    private List<Employee> employees = new ArrayList<>();

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Skill [id=" + id + ", name=" + name + "]";
    }
}
