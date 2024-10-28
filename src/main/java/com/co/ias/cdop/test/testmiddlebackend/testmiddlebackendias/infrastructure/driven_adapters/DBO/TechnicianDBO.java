package com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.infrastructure.driven_adapters.DBO;

import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.Technician;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "technician")
public class TechnicianDBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30, nullable = false)
    private String name;

    public static TechnicianDBO fromDomain(Technician technician) {
        return new TechnicianDBO(technician.getId(), technician.getName());
    }

    public Technician toDomain(){
        return new Technician(this.id, this.name);
    }
}
