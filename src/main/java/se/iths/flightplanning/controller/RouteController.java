package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
}
