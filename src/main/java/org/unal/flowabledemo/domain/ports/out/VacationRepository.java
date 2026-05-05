package org.unal.flowabledemo.domain.ports.out;

import org.unal.flowabledemo.domain.models.VacationRequest;

public interface VacationRepository {
    void save(VacationRequest request);
}
