package org.unal.flowabledemo.infrastructure.adapters.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unal.flowabledemo.domain.models.VacationRequest;
import org.unal.flowabledemo.domain.ports.in.VacationUseCase;

@RestController
@RequestMapping("/vacations")
public class VacationController {

    private final VacationUseCase vacationUseCase;

    public VacationController(VacationUseCase vacationUseCase) {
        this.vacationUseCase = vacationUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> request(@RequestBody VacationRequest request) {
        vacationUseCase.requestVacation(request.getEmployee(), request.getDays());
        return ResponseEntity.ok().build();
    }
}
