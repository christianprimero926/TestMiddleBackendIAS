package com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.infrastructure.driven_adapters;

import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.Service;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.infrastructure.driven_adapters.DBO.ServiceDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface IServiceRepository extends JpaRepository<ServiceDBO, Integer> {

//    @Query("SELECT s FROM ServiceDBO s WHERE s.technician.id = :technicianId AND s.startDateTime >= :startDate AND s.endDateTime <= :endDate")
//    Flux<Service> findServicesByTechnicianAndDateRange(Integer technicianId, LocalDateTime startDate, LocalDateTime endDate);
}
