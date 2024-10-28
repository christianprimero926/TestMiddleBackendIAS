package com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.infrastructure.driven_adapters.DBO;

import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.Service;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "services")
public class ServiceDBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30, nullable = false)
    private String address;

    @Column(length = 100)
    private String description;

    @Column(nullable = false)
    private LocalDateTime startDateTime;

    @Column(nullable = false)
    private LocalDateTime endDateTime;

    @ManyToOne
    @JoinColumn(name = "technician_id", nullable = false)
    private TechnicianDBO technician;

    public static ServiceDBO fromDomain(Service service) {
        TechnicianDBO technicianDBO = TechnicianDBO.fromDomain(service.getTechnician());
        return new ServiceDBO(
                service.getId(),
                service.getAddress(),
                service.getDescription(),
                service.getStartDateTime(),
                service.getEndDateTime(),
                technicianDBO);
    }

    public Service toDomain() {
        return new Service(
                this.id,
                this.address,
                this.description,
                this.startDateTime,
                this.endDateTime,
                technician.toDomain()
        );
    }
}
