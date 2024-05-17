package com.example.testbackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Services {
    @Id
    private Integer id;

    @Column(nullable = false)
    private String address;

    private String description;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @ManyToOne
    private Technician technicianId;

}
