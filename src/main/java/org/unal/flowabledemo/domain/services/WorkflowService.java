package org.unal.flowabledemo.domain.services;

import org.unal.flowabledemo.domain.models.Procedure;
import org.unal.flowabledemo.domain.valueObjects.WorkflowProcedure;

import java.util.Optional;

public interface WorkflowService {
    void startProcedure(String id);
    Optional<WorkflowProcedure> getProcedure(String id);
    void completeTask(String id);
}
