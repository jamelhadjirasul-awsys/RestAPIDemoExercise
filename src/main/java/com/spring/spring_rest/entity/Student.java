package com.spring.spring_rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a student record stored in the database.
 */
@Entity 
@Table (name="student")
public class Student {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * Creates an empty student entity.
     */
    public Student() {
    }

    /**
     * Creates a student with all fields.
     *
     * @param id student ID
     * @param firstName student's first name
     * @param lastName student's last name
     * @param email student's email address
     */
    public Student(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Creates a student with a first and last name.
     *
     * @param firstName student's first name
     * @param lastName student's last name
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a readable representation of this student.
     *
     * @return the student's field values as text
     */
    @Override
    public String toString() {
        return "Student [id=" + id + 
                ", firstName=" + firstName + 
                ", lastName=" + lastName + 
                ", email=" + email + "]";
    }

    
    

    

}
