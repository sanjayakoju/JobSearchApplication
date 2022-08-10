package com.ea.cs544.jobsearchapplication.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestResponse {

    private String message;
    private Object detail;

    public ResponseEntity<?> successModel(Object object) {
        RestResponse restResponse = new RestResponse();
        restResponse.setMessage("SUCCESS");
        restResponse.setDetail(object);
        return new ResponseEntity<>(restResponse, HttpStatus.OK);
    }

    public ResponseEntity<?> failureModel(String message) {
        RestResponse restResponse = new RestResponse();
        restResponse.setMessage(message);
        return new ResponseEntity<>(restResponse, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> failureModel(HttpStatus httpStatus, String message) {
        RestResponse restResponse = new RestResponse();
        restResponse.setMessage(message);
        return new ResponseEntity<>(restResponse, httpStatus);
    }


    public RestResponse() {
    }

    public RestResponse(String message, Object detail) {
        this.message = message;
        this.detail = detail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }
}
