package org.unal.flowabledemo.application.services;

import org.flowable.engine.RuntimeService;
import org.springframework.stereotype.Service;
import org.unal.flowabledemo.domain.models.VacationRequest;
import org.unal.flowabledemo.domain.ports.in.VacationUseCase;
import org.unal.flowabledemo.domain.ports.out.VacationRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class VacationService implements VacationUseCase {

    private final VacationRepository repository;
    private final RuntimeService runtimeService;

    public VacationService(VacationRepository repository, RuntimeService runtimeService) {
        this.repository = repository;
        this.runtimeService = runtimeService;
    }

    @Override
    public void requestVacation(String employee, int days) {
        VacationRequest request = new VacationRequest(UUID.randomUUID().toString(), employee, days, "PENDING");

        repository.save(request);

        Map<String, Object> variables = new HashMap<>();
        variables.put("employee", employee);
        variables.put("days", days);

        runtimeService.startProcessInstanceByKey("vacationProcess", variables);
    }
}
