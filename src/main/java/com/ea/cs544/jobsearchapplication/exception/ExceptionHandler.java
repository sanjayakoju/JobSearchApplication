package com.ea.cs544.jobsearchapplication.exception;

public class ExceptionHandler {

    public static void handleException(String message) {
        throw new ResourceNotFoundException(message);
    }
}
