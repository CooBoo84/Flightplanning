package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import se.iths.flightplanning.dto.RouteDto;

import org.springframework.web.server.ResponseStatusException;

import se.iths.flightplanning.entity.RouteEntity;
import se.iths.flightplanning.service.RouteService;

@RestController
@RequestMapping("routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping()
    public ResponseEntity<RouteEntity> createRoute(@RequestBody RouteEntity routeEntity) {
        RouteEntity createdRoute = routeService.createRoute(routeEntity);
        return new ResponseEntity<>(createdRoute, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Iterable<RouteEntity>> findAllRoutes() {
        Iterable<RouteEntity> allRoutes = routeService.findAllRoutes();
        return new ResponseEntity<>(allRoutes, HttpStatus.OK);
    }

    @GetMapping("routeDto")
    public ResponseEntity<Iterable<RouteDto>> findAllRoutesDto() {
        Iterable<RouteDto> allRoutes = routeService.findAllRoutesDto();
        return new ResponseEntity<>(allRoutes, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public RouteEntity findRouteById(@PathVariable Long id) {
        return routeService.getRouteById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id " + id + " not found."));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRouteById(@PathVariable Long id) {
        routeService.deleteRouteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
