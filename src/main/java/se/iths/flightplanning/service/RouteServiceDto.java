package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.RouteDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface RouteServiceDto {

    List<RouteDto> findAllRoutes();

    Optional<RouteDto> getRouteByid(Long id);

    RouteDto createRoute(RouteDto routeDto);

    void deleteRouteById(Long id);
}
