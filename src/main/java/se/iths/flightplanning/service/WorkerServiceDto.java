package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.WorkerDto;


public interface WorkerServiceDto {

    Iterable<WorkerDto> findAllWorkersDto();


}