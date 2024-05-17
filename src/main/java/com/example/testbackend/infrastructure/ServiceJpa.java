package com.example.testbackend.infrastructure;

import com.example.testbackend.domain.Services;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceJpa extends JpaRepository<Services, Integer> {
}
