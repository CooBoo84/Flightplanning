package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.RouteDto;
import se.iths.flightplanning.dto.WorkerDto;

import java.util.List;
import java.util.Optional;

public interface WorkerServiceDto {

    WorkerDto createWorker(WorkerDto workerDto);

    List<WorkerDto> findAllWorkers();

    Optional<WorkerDto> getWorkerById(Long id);

    void deleteWorkerById(Long id);
}
