package com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.usecase;

import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.Technician;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.gateway.TechnicianRepositoryGateway;
import reactor.core.publisher.Mono;


public class TechnicianUseCase {
    private final TechnicianRepositoryGateway technicianRepositoryGateway;

    public TechnicianUseCase(TechnicianRepositoryGateway technicianRepositoryGateway) {
        this.technicianRepositoryGateway = technicianRepositoryGateway;
    }

    public Mono<Technician> createTechnician(Technician technician) {
        return Mono.fromCallable(() -> {
            technicianRepositoryGateway.save(technician);
            return technician;
        });
    }
}
