package com.spring.spring_rest.exception;

/**
 * Indicates that the requested student does not exist.
 */
public class StudentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2690100046087976236L;

    /**
     * Creates the exception with a message and cause.
     *
     * @param message details about the missing student
     * @param cause underlying cause
     */
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates the exception with a message.
     *
     * @param message details about the missing student
     */
    public StudentNotFoundException(String message) {
        super(message);
    }

    /**
     * Creates the exception with a cause.
     *
     * @param cause underlying cause
     */
    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }


}
