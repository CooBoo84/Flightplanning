package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.iths.flightplanning.dto.AirplaneDto;
import se.iths.flightplanning.exception.EmptyListException;
import se.iths.flightplanning.service.AirplaneServiceDto;

@RestController
@RequestMapping("airplanes")
public class AirplaneController {

    private final AirplaneServiceDto airplaneServiceDto;

    public AirplaneController(AirplaneServiceDto airplaneServiceDto) {
        this.airplaneServiceDto = airplaneServiceDto;
    }

    @PostMapping()
    public ResponseEntity<AirplaneDto> createPlane(@RequestBody AirplaneDto airplaneDto) {
        AirplaneDto createdPlane = airplaneServiceDto.createPlane(airplaneDto);
        return new ResponseEntity<>(createdPlane, HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<Iterable<AirplaneDto>> findAllPlanes() {
        Iterable<AirplaneDto> allPlanes = airplaneServiceDto.findAllPlanes();
        if (allPlanes.iterator().hasNext())
            return new ResponseEntity<>(allPlanes, HttpStatus.OK);
        else
            throw new EmptyListException("Airplane list is empty.");
    }

    @GetMapping("{id}")
    public AirplaneDto findAirplaneById(@PathVariable Long id) {
        return airplaneServiceDto.getAirplaneById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Id " + id + " not found."));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAnAirplaneById(@PathVariable Long id) {
        airplaneServiceDto.deleteAirplaneById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/")
    @ResponseBody
    public String getFooByIdUsingQueryParam(@RequestParam String id) {
        return "ID: " + id;
    }

}
