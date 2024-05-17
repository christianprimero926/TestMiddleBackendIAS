package com.example.testbackend.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public ResponseEntity<Object> generateResponse(Object respObject, HttpStatus status, String message){
        Map<String, Object> response = new HashMap<>();
        response.put("data:", respObject);
        response.put("status:", status);
        response.put("message:", message);

    }
}
