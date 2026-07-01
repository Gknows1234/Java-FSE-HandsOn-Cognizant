package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Skill;

/**
 * Repository for the Skill entity.
 * Provides standard CRUD operations via JpaRepository.
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
