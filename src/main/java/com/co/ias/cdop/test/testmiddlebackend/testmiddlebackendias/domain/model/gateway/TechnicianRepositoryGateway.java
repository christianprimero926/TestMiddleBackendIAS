package com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.gateway;

import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.domain.model.Technician;

public interface TechnicianRepositoryGateway {
    Technician save(Technician technician);
    Technician findTechnicianById(Integer id);
}
