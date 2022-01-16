package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.dto.AirplaneDto;
import se.iths.flightplanning.entity.AirplaneEntity;
import se.iths.flightplanning.mappers.AirplaneMapper;
import se.iths.flightplanning.repository.AirplaneRepository;

import java.util.Optional;


@Service
public class AirplaneService implements AirplaneServiceDto {

    private final AirplaneRepository airplaneRepository;

    private final AirplaneMapper airplaneMapper;

    public AirplaneService(AirplaneRepository airplaneRepository, AirplaneMapper airplaneMapper) {
        this.airplaneRepository = airplaneRepository;
        this.airplaneMapper = airplaneMapper;
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

    @Override
    public Iterable<AirplaneDto> findAllPlanesDTO() {
        return airplaneMapper.mapp(airplaneRepository.findAll());
    }
}
