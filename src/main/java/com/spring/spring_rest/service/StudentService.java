package com.spring.spring_rest.service;

import java.util.List;
import com.spring.spring_rest.dto.StudentDto;

/**
 * Defines operations for managing student records.
 */
public interface StudentService {

    /**
     * Creates a student from the supplied data.
     *
     * @param thStudentDto data for the new student
     * @return the created student
     * @throws AlreadyExistingEmailException if the email is already in use
     */
    StudentDto createStudent(StudentDto thStudentDto);

    /**
     * Finds a student by ID.
     *
     * @param theId ID of the student
     * @return the matching student
     */
    StudentDto getStudentById(Long theId);

    /**
     * Retrieves all students.
     *
     * @return all student records
     */
    List<StudentDto> getAllStudents();

    /**
     * Replaces the data of an existing student.
     *
     * @param theId ID of the student to update
     * @param thStudentDto replacement student data
     * @return the updated student
     * @throws AlreadyExistingEmailException if the email 
     * is already in use by another student
     */
    StudentDto updateStudent(Long theId, StudentDto thStudentDto);

    /**
     * Updates the supplied fields of an existing student.
     *
     * @param theId ID of the student to update
     * @param theStudentDto fields to update
     * @return the updated student
     * @throws AlreadyExistingEmailException if the email 
     * is already in use by another student
     */
    StudentDto patchStudent(Long theId, StudentDto theStudentDto);

    /**
     * Deletes a student by ID.
     *
     * @param theId ID of the student to delete
     * @throws StudentNotFoundException if no student has that ID
     */
    void deleteStudentById(Long theId);
}
