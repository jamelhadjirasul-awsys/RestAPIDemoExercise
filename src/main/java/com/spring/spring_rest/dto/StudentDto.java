package com.spring.spring_rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

/**
 * Carries student data between the API and service layers.
 */
public class StudentDto {

    private Long id;

    @Size(min = 2, max = 50, message = "Must be 2 to 15 characters.")
    private String firstName;

    @Size(min = 2, max = 50, message = "Must be 2 to 15 characters.")
    private String lastName;

    @Email(message = "Email is required and should be valid")
    private String email;

    /**
     * Creates a DTO with the supplied student data.
     *
     * @param id student ID
     * @param firstName student's first name
     * @param lastName student's last name
     * @param email student's email address
     */
    public StudentDto(Long id, String firstName, 
                        String lastName, String email) {
                            
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    

    
}
