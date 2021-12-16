package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.flightplanning.dto.RouteDto;
import se.iths.flightplanning.service.RouteService;

@RestController
@RequestMapping("routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping()
    public ResponseEntity<RouteDto> createRoute(@RequestBody RouteDto routeDto) {
        RouteDto createdRoute = routeService.createRoute(routeDto);
        return new ResponseEntity<>(createdRoute, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Iterable<RouteDto>> findAllRoutes() {
        Iterable<RouteDto> allRoutes = routeService.findAllRoutes();
        return new ResponseEntity<>(allRoutes, HttpStatus.OK);
    }
}
