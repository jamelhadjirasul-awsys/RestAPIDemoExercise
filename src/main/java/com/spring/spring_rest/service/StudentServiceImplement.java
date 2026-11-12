package com.spring.spring_rest.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.repository.StudentRepository;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.AlreadyExistingEmailException;
import com.spring.spring_rest.exception.StudentNotFoundException;

/**
 * Implements student operations using the student repository.
 */
@Service 
public class StudentServiceImplement implements StudentService {

    private StudentRepository studentRepo;

    /**
     * Creates the service with its repository dependency.
     *
     * @param studentRepo repository used to access student records
     */
    public StudentServiceImplement(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override 
    public StudentDto createStudent(StudentDto thStudentDto) {
        if (studentRepo.existsByEmail(thStudentDto.getEmail())) {
            throw new AlreadyExistingEmailException("Email already exists.");
        }

        Student theStudent = StudentMapper.mapToStudent(thStudentDto);
        Student savedStudent = studentRepo.save(theStudent);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    /**
     * {@inheritDoc}
     */
    @Override 
    public StudentDto getStudentById(Long theId) {
        Student student = studentRepo.findById(theId).orElseThrow(() -> 
        new StudentNotFoundException("Student id " + theId + " not found!"));
    
        return StudentMapper.mapToStudentDto(student);
    }

    /**
     * {@inheritDoc}
     */
    @Override 
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return students.stream().map(
            (student)-> StudentMapper.mapToStudentDto(student))
            .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override 
    public StudentDto updateStudent(Long theId, StudentDto theStudentDto) {
        Student student = studentRepo.findById(theId).orElseThrow(() -> 
        new StudentNotFoundException("Student id " + theId + " not found!"));

        if (studentRepo.existsByEmailAndIdNot(theStudentDto.getEmail(), theId)) {
            throw new AlreadyExistingEmailException("Email already exists.");
        }

        student.setFirstName(theStudentDto.getFirstName());
        student.setLastName(theStudentDto.getLastName());
        student.setEmail(theStudentDto.getEmail());

        Student savedStudent = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    /**
     * {@inheritDoc}
     */
    @Override 
    public StudentDto patchStudent(Long theId, StudentDto theStudentDto) {
        Student student = studentRepo.findById(theId).orElseThrow(() -> 
        new StudentNotFoundException("Student id " + theId + " not found!"));
    
        if (theStudentDto.getFirstName() != null) {
            student.setFirstName(theStudentDto.getFirstName());
        }
        if (theStudentDto.getLastName() != null) {
            student.setLastName(theStudentDto.getLastName());
        }
        if (theStudentDto.getEmail() != null) {
            if (studentRepo.existsByEmailAndIdNot(theStudentDto.getEmail(), 
                                                    theId)) {
                throw new 
                    AlreadyExistingEmailException("Email already exists.");
            }
            student.setEmail(theStudentDto.getEmail());
        }

        Student savedStudent = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    /**
     * {@inheritDoc}
     */
    @Override 
    public void deleteStudentById(Long theId) {
        studentRepo.findById(theId).orElseThrow(() -> 
        new StudentNotFoundException("Student id: " + theId + " not found!"));
    
        studentRepo.deleteById(theId);
    }

}
