package com.example.testbackend.infrastructure;

import com.example.testbackend.domain.Services;

import java.util.List;

public interface IServicesRepository {
    public List<Services> getServices();
}
