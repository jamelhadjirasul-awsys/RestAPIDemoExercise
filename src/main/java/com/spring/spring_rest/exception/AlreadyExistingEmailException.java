package com.spring.spring_rest.exception;

/**
 * Indicates that a student email address is already in use.
 */
public class AlreadyExistingEmailException extends RuntimeException{

     /**
      * Creates the exception with a message.
      *
      * @param message details about the duplicate email
      */
     public AlreadyExistingEmailException(String message) {
        super(message);
    }

     /**
      * Creates the exception with a cause.
      *
      * @param cause underlying cause
      */
     public AlreadyExistingEmailException(Throwable cause) {
        super(cause);
    }

     /**
      * Creates the exception with a message and cause.
      *
      * @param message details about the duplicate email
      * @param cause underlying cause
      */
     public AlreadyExistingEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
