package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.flightplanning.entity.AirplaneEntity;


import se.iths.flightplanning.exception.NoContentException;
import se.iths.flightplanning.exception.NoRecordFoundException;
import se.iths.flightplanning.service.AirplaneService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

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
        return new ResponseEntity<>(allPlanes, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<AirplaneEntity> findAnAirplaneById(@PathVariable Long id) {
        AirplaneEntity foundAirplane = airplaneService.findById(id);
        if (foundAirplane == null) {
            throw new NoRecordFoundException();
        }
        return new ResponseEntity<>(foundAirplane, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<AirplaneEntity> findAirplaneByName(@RequestParam String name) {
        AirplaneEntity foundAirplane = airplaneService.findByName(name);
        if (foundAirplane == null) {
            throw new NoRecordFoundException();
        }
        return new ResponseEntity<>(foundAirplane, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAnAirplaneById(@PathVariable Long id) {
        airplaneService.deleteAirplaneById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/")
    @ResponseBody
    public String getFooByIdUsingQueryParam(@RequestParam String id) {
        return "ID: " + id;
    }

}
