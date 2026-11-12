package com.spring.spring_rest.repository;

import com.spring.spring_rest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides database access to student entities.
 */
public interface StudentRepository extends JpaRepository<Student, Long>{

}
