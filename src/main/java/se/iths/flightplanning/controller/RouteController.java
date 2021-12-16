package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.flightplanning.dto.RouteDto;
import se.iths.flightplanning.service.RouteServiceDto;

@RestController
@RequestMapping("routes")
public class RouteController {

    private final RouteServiceDto routeServiceDto;

    public RouteController(RouteServiceDto routeServiceDto) {
        this.routeServiceDto = routeServiceDto;
    }

    @PostMapping()
    public ResponseEntity<RouteDto> createRoute(@RequestBody RouteDto routeDto) {
        RouteDto createdRoute = routeServiceDto.createRoute(routeDto);
        return new ResponseEntity<>(createdRoute, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Iterable<RouteDto>> findAllRoutes() {
        Iterable<RouteDto> allRoutes = routeServiceDto.findAllRoutes();
        return new ResponseEntity<>(allRoutes, HttpStatus.OK);
    }
}
