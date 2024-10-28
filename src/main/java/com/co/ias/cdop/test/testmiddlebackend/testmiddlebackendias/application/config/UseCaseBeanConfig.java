package com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.application.config;

import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.gateway.ServiceRepositoryGateway;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.gateway.TechnicianRepositoryGateway;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.usecase.ServiceUseCase;
import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.usecase.TechnicianUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {
    @Bean
    public ServiceUseCase serviceUseCase(ServiceRepositoryGateway serviceRepositoryGateway, TechnicianRepositoryGateway technicianRepositoryGateway) {
        return new ServiceUseCase(serviceRepositoryGateway,technicianRepositoryGateway);
    }
    @Bean
    public TechnicianUseCase technicianUseCase(TechnicianRepositoryGateway technicianRepositoryGateway) {
        return new TechnicianUseCase(technicianRepositoryGateway);
    }
}
