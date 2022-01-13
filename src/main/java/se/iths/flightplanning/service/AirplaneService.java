package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.AirplaneEntity;
import se.iths.flightplanning.repository.AirplaneRepository;

import java.util.Optional;


@Service
public class AirplaneService  {

    private final AirplaneRepository airplaneRepository;

    public AirplaneService(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }


    public AirplaneEntity createPlane(AirplaneEntity airplaneEntity) {
        if (airplaneEntity.getAirplaneName().isEmpty())
            throw new RuntimeException();
        return airplaneRepository.save(airplaneEntity);
    }


    public Iterable<AirplaneEntity> findAllPlanes() {
        return airplaneRepository.findAll();
    }


    public Optional<AirplaneEntity> getAirplaneById(Long id) {
        return airplaneRepository.findById(id);
    }


    public void deleteById(Long id) {
        airplaneRepository.deleteById(id);
    }
}
