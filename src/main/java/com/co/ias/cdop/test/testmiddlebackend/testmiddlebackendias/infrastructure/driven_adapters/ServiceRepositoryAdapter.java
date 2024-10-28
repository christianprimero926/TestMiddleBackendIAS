package com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.infrastructure.driven_adapters;

import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.Service;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.gateway.ServiceRepositoryGateway;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.infrastructure.driven_adapters.DBO.ServiceDBO;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.infrastructure.driven_adapters.DBO.TechnicianDBO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ServiceRepositoryAdapter implements ServiceRepositoryGateway {
    private final IServiceRepository serviceRepository;

    public ServiceRepositoryAdapter(IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Service save(Service service) {
        ServiceDBO serviceDBO = ServiceDBO.fromDomain(service);
        serviceRepository.save(serviceDBO);
        return serviceDBO.toDomain();
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable).map(ServiceDBO::toDomain);
    }

    @Override
    public Service findById(Integer id) {
        return serviceRepository.findById(id).map(ServiceDBO::toDomain).orElse(null);
    }

//    @Override
//    public Flux<Service> findServicesByTechnicianAndDateRange(Integer technicianId, LocalDateTime startDate, LocalDateTime endDate) {
//        return serviceRepository.findServicesByTechnicianAndDateRange(technicianId, startDate, endDate);
//    }
}
