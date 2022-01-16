package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.RouteDto;

public interface RouteServiceDto {

    Iterable<RouteDto> findAllRoutesDto();
}
