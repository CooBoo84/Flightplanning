package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.RouteDto;

import java.util.List;
import java.util.Optional;

public interface RouteServiceDto {

    List<RouteDto> findAllRoutes();

    Optional<RouteDto> getRouteById(Long id);

    RouteDto createRoute(RouteDto routeDto);

    void deleteRouteById(Long id);
}
