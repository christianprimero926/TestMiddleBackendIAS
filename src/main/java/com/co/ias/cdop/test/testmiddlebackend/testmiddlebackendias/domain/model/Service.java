package com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model;


import java.time.LocalDateTime;

public class Service {
    private Integer id;
    private String address;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Technician technician;

    public Service(Integer id, String address, String description, LocalDateTime startDateTime, LocalDateTime endDateTime, Technician technician) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.technician = technician;
    }

    public Service() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", technician=" + technician +
                '}';
    }
}
