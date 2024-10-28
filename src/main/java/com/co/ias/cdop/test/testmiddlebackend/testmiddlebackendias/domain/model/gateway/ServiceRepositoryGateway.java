package com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.gateway;

import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.List;

public interface ServiceRepositoryGateway {
    Service save(Service service);
    Page<Service> findAll(Pageable pageable);
    Service findById(Integer id);
//    Flux<Service> findServicesByTechnicianAndDateRange(Integer technicianId, LocalDateTime startDate, LocalDateTime endDate);

}
