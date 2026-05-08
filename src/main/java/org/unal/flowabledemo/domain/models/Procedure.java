package org.unal.flowabledemo.domain.models;

import org.unal.flowabledemo.domain.ProcedureStatus;

import java.util.UUID;

public class Procedure {
    private UUID id;
    private ProcedureStatus status;

    public Procedure() {
        this.id = UUID.randomUUID();
        this.status = ProcedureStatus.PENDING;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProcedureStatus getStatus() {
        return status;
    }

    public void setStatus(ProcedureStatus status) {
        this.status = status;
    }
}
