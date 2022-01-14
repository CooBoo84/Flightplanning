package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.WorkerDto;

import java.util.List;

public interface WorkerServiceDto {

    WorkerDto createWorker(WorkerDto workerDto);

    List<WorkerDto> findAllWorkers();

    void deleteById(Long id);
}