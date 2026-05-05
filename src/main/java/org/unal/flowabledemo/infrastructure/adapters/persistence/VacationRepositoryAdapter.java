package org.unal.flowabledemo.infrastructure.adapters.persistence;

import org.springframework.stereotype.Repository;
import org.unal.flowabledemo.domain.models.VacationRequest;
import org.unal.flowabledemo.domain.ports.out.VacationRepository;

@Repository
public class VacationRepositoryAdapter implements VacationRepository {

    @Override
    public void save(VacationRequest request) {
        System.out.println("Request saved...");
        System.out.println(request);
    }
}
