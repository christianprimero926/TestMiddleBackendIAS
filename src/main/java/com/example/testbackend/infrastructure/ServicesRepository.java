package com.example.testbackend.infrastructure;

import com.example.testbackend.domain.Services;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesRepository implements IServicesRepository{
    private final ServiceJpa serviceJpa;

    public ServicesRepository(ServiceJpa serviceJpa) {
        this.serviceJpa = serviceJpa;
    }

    @Override
    public List<Services> getServices() {
        return List.of();
    }
}
