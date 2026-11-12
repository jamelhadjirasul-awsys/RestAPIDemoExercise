package com.spring.spring_rest.service;

import java.util.List;
import com.spring.spring_rest.dto.StudentDto;

/**
 * Defines operations for managing student records.
 */
public interface StudentService {

    StudentDto createStudent(StudentDto thStudentDto);
    StudentDto getStudentById(Long theId);
    List<StudentDto> getAllStudents();
    StudentDto updateStudent(Long theId, StudentDto thStudentDto);
    StudentDto patchStudent(Long theId, StudentDto theStudentDto);
    void deleteStudentById(Long theId);
}
