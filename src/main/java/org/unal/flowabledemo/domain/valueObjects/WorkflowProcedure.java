package org.unal.flowabledemo.domain.valueObjects;

import java.util.UUID;

public class WorkflowProcedure {
    private String id;
    private UUID procedureId;

    public WorkflowProcedure(String id, UUID procedureId) {
        this.id = id;
        this.procedureId = procedureId;
    }
}
