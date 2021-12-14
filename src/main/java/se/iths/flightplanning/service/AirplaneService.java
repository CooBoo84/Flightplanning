package se.iths.flightplanning.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.AirplaneEntity;
import se.iths.flightplanning.repository.AirplaneRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;


@Service
public class AirplaneService {

    private final AirplaneRepository airplaneRepository;

    public AirplaneService(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    public AirplaneEntity createPlane(AirplaneEntity airplaneEntity) {
        return airplaneRepository.save(airplaneEntity);
    }

    public Iterable<AirplaneEntity> findAllPlanes() {
        return airplaneRepository.findAll();
    }

    public AirplaneEntity findById(Long id) {
        return airplaneRepository.findAirplaneEntityById(id);
    }

    public AirplaneEntity findByName(String airplaneName) {
        return airplaneRepository.findByAirplaneName(airplaneName);
    }

    public void deleteAirplaneById(Long id) {
        AirplaneEntity foundAirplane = airplaneRepository.findAirplaneEntityById(id);
        airplaneRepository.deleteById(foundAirplane.getId());
    }

    /*public void deleteAirplaneByName(String name) {
        airplaneRepository.deleteAirplaneEntityByAirplaneName(name);
    }*/

}
