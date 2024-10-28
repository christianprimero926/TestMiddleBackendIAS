package com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.infrastructure.entry_points;

import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.Service;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.Technician;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.usecase.ServiceUseCase;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.usecase.TechnicianUseCase;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class ApiRest {
    private final ServiceUseCase serviceUseCase;
    private final TechnicianUseCase technicianUseCase;

    public ApiRest(ServiceUseCase serviceUseCase, TechnicianUseCase technicianUseCase) {
        this.serviceUseCase = serviceUseCase;
        this.technicianUseCase = technicianUseCase;
    }

    @PostMapping("/technicians")
    public Mono<ResponseEntity<ApiResponse<Technician>>> createTechnician(@RequestBody Technician technician) {
        return technicianUseCase.createTechnician(technician)
                .map(createdTechnician -> {
                    ApiResponse<Technician> response = new ApiResponse<>(createdTechnician, HttpStatus.CREATED, "Técnico creado exitosamente");
                    return ResponseEntity.status(HttpStatus.CREATED).body(response);

                }).onErrorResume(throwable -> {
                    ApiResponse<Technician> errorResponse = new ApiResponse<>(null, HttpStatus.INTERNAL_SERVER_ERROR, throwable.getMessage());
                    return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse));
                });
    }

    @PostMapping("/services")
    public Mono<ResponseEntity<ApiResponse<Service>>> createService(@RequestBody Service service) {
        return serviceUseCase.createService(service)
                .map(createdService -> {
                    ApiResponse<Service> response = new ApiResponse<>(createdService, HttpStatus.CREATED, "Servicio creado exitosamente");
                    return ResponseEntity.status(HttpStatus.CREATED).body(response);

                }).onErrorResume(throwable -> {
                    ApiResponse<Service> errorResponse = new ApiResponse<>(null, HttpStatus.INTERNAL_SERVER_ERROR, throwable.getMessage());
                    return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse));
                });
    }

    @GetMapping("/services")
    public Mono<ResponseEntity<ApiResponse<List<Service>>>> getAllServices(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return serviceUseCase.getAllServices(pageable)
                .collectList()
                .map(service -> {
                    ApiResponse<List<Service>> response = new ApiResponse<>(service, HttpStatus.OK, "Respuesta ok");
                    return ResponseEntity.ok(response);
                });
    }

    @GetMapping("/services/{id}")
    public Mono<ResponseEntity<ApiResponse<Service>>> getServiceById(@PathVariable Integer id) {
        return serviceUseCase.getServiceById(id)
                .map(service -> {
                    ApiResponse<Service> response = new ApiResponse<>(service, HttpStatus.OK, "Servicio encontrado");
                    return ResponseEntity.ok(response);
                })
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(null, HttpStatus.NOT_FOUND, "Servicio no encontrado")))
                .onErrorResume(throwable -> {
                    ApiResponse<Service> errorResponse = new ApiResponse<>(null, HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener el servicio: " + throwable.getMessage());
                    return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse));
                });
    }

}
