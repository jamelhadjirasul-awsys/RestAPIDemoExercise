package com.spring.spring_rest.repository;

import com.spring.spring_rest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides database access to student entities.
 */
public interface StudentRepository extends JpaRepository<Student, Long>{

    /**
     * Checks whether an email address belongs to any student.
     *
     * @param email email address to check
     * @return {@code true} if a student uses the email
     */
    boolean existsByEmail(String email);

    /**
     * Checks whether an email belongs to a student other than the specified one.
     *
     * @param email email address to check
     * @param id ID of the student to exclude
     * @return {@code true} if another student uses the email
     */
    boolean existsByEmailAndIdNot(String email, Long id);
}
