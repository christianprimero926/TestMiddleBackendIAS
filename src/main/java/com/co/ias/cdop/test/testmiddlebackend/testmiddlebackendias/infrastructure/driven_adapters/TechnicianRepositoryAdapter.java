package com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.infrastructure.driven_adapters;

import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.Technician;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.gateway.TechnicianRepositoryGateway;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.infrastructure.driven_adapters.DBO.TechnicianDBO;
import org.springframework.stereotype.Repository;

@Repository
public class TechnicianRepositoryAdapter implements TechnicianRepositoryGateway {
    private final ITechnicianRepository technicianRepository;

    public TechnicianRepositoryAdapter(ITechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    @Override
    public Technician save(Technician technician) {
        TechnicianDBO technicianDBO = TechnicianDBO.fromDomain(technician);
        technicianRepository.save(technicianDBO);
        return technicianDBO.toDomain();
    }

    @Override
    public Technician findTechnicianById(Integer id) {
        return technicianRepository.findById(id)
                .map(TechnicianDBO::toDomain)
                .orElse(null);
    }
}
