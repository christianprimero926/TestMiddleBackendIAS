package com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.usecase;

import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.Technician;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.gateway.ServiceRepositoryGateway;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.Service;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.gateway.TechnicianRepositoryGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


public class ServiceUseCase {
    private final ServiceRepositoryGateway serviceRepositoryGateway;
    private final TechnicianRepositoryGateway technicianRepositoryGateway;

    public ServiceUseCase(ServiceRepositoryGateway serviceRepositoryGateway, TechnicianRepositoryGateway technicianRepositoryGateway) {
        this.serviceRepositoryGateway = serviceRepositoryGateway;
        this.technicianRepositoryGateway = technicianRepositoryGateway;
    }

    public Flux<Service> getAllServices(Pageable pageable) {
        return Flux.defer(() -> {
            Page<Service> page = serviceRepositoryGateway.findAll(pageable);
            return Flux.fromIterable(page.getContent());
        });
    }

    public Mono<Service> getServiceById(Integer id) {
        return Mono.fromCallable(() -> {
            Service service = serviceRepositoryGateway.findById(id);
            if (service == null) {
                throw new RuntimeException("Service not found with ID: "+id);
            }
            return service;
        });
    }

    public Mono<Service> createService(Service service) {
        Technician technician = technicianRepositoryGateway.findTechnicianById(service.getTechnician().getId());
        if (technician == null) {
            throw new RuntimeException("Técnico no encontrado con ID: " + service.getTechnician().getId());
        }
        return Mono.fromCallable(() -> {
            serviceRepositoryGateway.save(service);
            return service;
        });
    }

//    public Flux<Service> getServicesByTechnicianAndDateRange(Integer technicianId, LocalDateTime startDate, LocalDateTime endDate) {
//        return serviceRepositoryGateway.findServicesByTechnicianAndDateRange(technicianId, startDate, endDate);
//    }
}
