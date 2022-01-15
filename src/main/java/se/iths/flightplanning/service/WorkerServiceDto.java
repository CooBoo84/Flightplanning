package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.RouteDto;
import se.iths.flightplanning.dto.WorkerDto;

import java.util.List;
import java.util.Optional;

public interface WorkerServiceDto {

     //WorkerDto createWorker(WorkerDto workerDto);

    Iterable<WorkerDto> findAllWorkersDto();


   // void deleteById(Long id);
}