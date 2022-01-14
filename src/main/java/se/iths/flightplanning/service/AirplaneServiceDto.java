package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.AirplaneDto;

import java.util.List;
import java.util.Optional;

public interface AirplaneServiceDto {

    List<AirplaneDto> findAllPlanes();

    Optional<AirplaneDto> getAirplaneById(Long id);

    AirplaneDto createPlane(AirplaneDto airplaneDto);

    void deleteById(Long id);
}