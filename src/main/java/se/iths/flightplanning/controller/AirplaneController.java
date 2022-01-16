package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.iths.flightplanning.dto.AirplaneDto;
import se.iths.flightplanning.entity.AirplaneEntity;
import se.iths.flightplanning.exception.EmptyListException;
import se.iths.flightplanning.service.AirplaneService;

@RestController
@RequestMapping("airplanes")
public class AirplaneController {

    private final AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @PostMapping()
    public ResponseEntity<AirplaneEntity> createPlane(@RequestBody AirplaneEntity airplaneEntity) {
        AirplaneEntity createdPlane = airplaneService.createPlane(airplaneEntity);
        return new ResponseEntity<>(createdPlane, HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<Iterable<AirplaneEntity>> findAllPlanes() {
        Iterable<AirplaneEntity> allPlanes = airplaneService.findAllPlanes();
        if (allPlanes.iterator().hasNext())
            return new ResponseEntity<>(allPlanes, HttpStatus.OK);
        else
            throw new EmptyListException("Airplane list is empty.");
    }

    @GetMapping("dto")
    public ResponseEntity<Iterable<AirplaneDto>> findAllPlanesDTO() {
        Iterable<AirplaneDto> allPlanes = airplaneService.findAllPlanesDTO();
        if (allPlanes.iterator().hasNext())
            return new ResponseEntity<>(allPlanes, HttpStatus.OK);
        else
            throw new EmptyListException("Airplane list is empty.");
    }

    @GetMapping("{id}")
    public AirplaneEntity findAirplaneById(@PathVariable Long id) {
        return airplaneService.getAirplaneById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Id " + id + " not found."));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAirplaneById(@PathVariable Long id) {
        airplaneService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/")
    @ResponseBody
    public String getFooByIdUsingQueryParam(@RequestParam String id) {
        return "ID: " + id;
    }

}
