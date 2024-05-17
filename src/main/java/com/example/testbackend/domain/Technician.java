package com.example.testbackend.domain;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Technician {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String name;
}
