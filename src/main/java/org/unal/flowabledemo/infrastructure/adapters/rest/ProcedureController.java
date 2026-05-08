package org.unal.flowabledemo.infrastructure.adapters.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unal.flowabledemo.domain.ProcedureStatus;
import org.unal.flowabledemo.domain.models.Procedure;

import java.util.UUID;

@RestController
@RequestMapping("/api/procedures")
public class ProcedureController {

    @PostMapping("/start")
    public ResponseEntity<String> start() {
        Procedure procedure = new Procedure();
        procedure.setId(UUID.randomUUID());
        procedure.setStatus(ProcedureStatus.REVIEW);

        return ResponseEntity.ok("Started");
    }
}
