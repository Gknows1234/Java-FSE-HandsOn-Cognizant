package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Department;

/**
 * Repository for the Department entity.
 * JpaRepository supplies findAll(), findById(), save(), and deleteById().
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
