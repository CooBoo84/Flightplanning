package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.AirplaneDto;

import java.util.List;
import java.util.Optional;

public interface AirplaneServiceDto {
    Iterable<AirplaneDto> findAllPlanesDTO();
}
