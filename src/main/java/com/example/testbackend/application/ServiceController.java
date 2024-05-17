package com.example.testbackend.application;

import com.example.testbackend.domain.IServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ServiceController {

    private final IServicesService service;



    @GetMapping
    public ResponseEntity<Object> getServices(int page, int size){
        return
    }

}
