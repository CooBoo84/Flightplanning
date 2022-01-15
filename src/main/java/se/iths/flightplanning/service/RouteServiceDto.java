package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.RouteDto;

import java.util.List;
import java.util.Optional;

public interface RouteServiceDto {

     Iterable<RouteDto> findAllRoutesDto();

//    Optional<RouteDto> getRouteByid(Long id);
//
//    RouteDto createRoute(RouteDto routeDto);
//
//    void deleteRouteById(Long id);
}