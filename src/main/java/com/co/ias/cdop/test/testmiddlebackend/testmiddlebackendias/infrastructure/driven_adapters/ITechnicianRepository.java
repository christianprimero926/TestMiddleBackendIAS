package com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.infrastructure.driven_adapters;

import com.co.ias.cdop.test.testmiddlebackend.testmiddlebackendias.infrastructure.driven_adapters.DBO.TechnicianDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechnicianRepository extends JpaRepository<TechnicianDBO, Integer> {
}
