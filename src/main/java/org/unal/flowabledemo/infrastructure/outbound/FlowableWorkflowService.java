package org.unal.flowabledemo.infrastructure.outbound;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.unal.flowabledemo.domain.ProcedureStatus;
import org.unal.flowabledemo.domain.models.Procedure;
import org.unal.flowabledemo.domain.services.WorkflowService;
import org.unal.flowabledemo.domain.valueObjects.WorkflowProcedure;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class FlowableWorkflowService implements WorkflowService {
    private final RuntimeService runtimeService;

    public FlowableWorkflowService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @Override
    public void startProcedure(String id) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("id", id);
        variables.put("status", "REVIEW");

        runtimeService.startProcessInstanceByKey("procedureProcess", variables);
    }

    @Override
    public Optional<WorkflowProcedure> getProcedure(String id) {
        ProcessInstance instance = runtimeService.createProcessInstanceQuery().processInstanceId(id).singleResult();

        UUID procedureId = (UUID) instance.getProcessVariables().get("id");

        return Optional.of(new WorkflowProcedure(instance.getProcessInstanceId(), procedureId));
    }

    @Override
    public void completeTask(String id) {
        ProcessInstance instance = runtimeService.createProcessInstanceQuery().processInstanceId(id).singleResult();

        ProcedureStatus status = (ProcedureStatus) instance.getProcessVariables().get("status");

        switch (status) {
            case REVIEW:
                runtimeService.setVariable(id, "status", "APPROVED");
                break;
            case APPROVED:
                runtimeService.setVariable(id, "status", "COMPLETED");
                break;
            default:
                throw new IllegalStateException("Invalid procedure status: " + status);
        }
    }
}
