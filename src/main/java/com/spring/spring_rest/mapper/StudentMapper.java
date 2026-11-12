package com.spring.spring_rest.mapper;

import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.dto.StudentDto;

/**
 * Converts between student entities and data transfer objects.
 */
public class StudentMapper {

    /**
     * Converts a student entity to a DTO.
     *
     * @param theStudent entity to convert
     * @return the corresponding student DTO
     */
    public static StudentDto mapToStudentDto(Student theStudent) {
        return new StudentDto(theStudent.getId(), 
                    theStudent.getFirstName(), 
                    theStudent.getLastName(),
                    theStudent.getEmail());
    }

    /**
     * Converts a student DTO to an entity.
     *
     * @param thStudentDto DTO to convert
     * @return the corresponding student entity
     */
    public static Student mapToStudent(StudentDto thStudentDto) {
        return new Student (thStudentDto.getId(),
                            thStudentDto.getFirstName(),
                            thStudentDto.getLastName(),
                            thStudentDto.getEmail());
    }
}
