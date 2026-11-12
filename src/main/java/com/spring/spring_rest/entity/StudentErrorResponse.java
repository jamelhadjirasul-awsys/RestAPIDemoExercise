package com.spring.spring_rest.entity;

/**
 * Holds the details returned for a student-related error.
 */
public class StudentErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

    /**
     * Creates an empty error response.
     */
    public StudentErrorResponse() {
    }

    /**
     * Creates an error response with all fields set.
     *
     * @param status HTTP status code
     * @param message error description
     * @param timeStamp time the error occurred
     */
    public StudentErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    
}
