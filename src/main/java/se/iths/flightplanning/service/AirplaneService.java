package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.dto.AirplaneDto;
import se.iths.flightplanning.mappers.AirplaneMapper;
import se.iths.flightplanning.repository.AirplaneRepository;

import java.util.List;
import java.util.Optional;


@Service
public class AirplaneService implements AirplaneServiceDto {

    private final AirplaneRepository airplaneRepository;
    private final AirplaneMapper airplaneMapper;

    public AirplaneService(AirplaneRepository airplaneRepository, AirplaneMapper airplaneMapper) {
        this.airplaneRepository = airplaneRepository;
        this.airplaneMapper = airplaneMapper;
    }

    @Override
    public AirplaneDto createPlane(AirplaneDto airplaneDto) {
        if (airplaneDto.getAirplaneName().isEmpty())
            throw new RuntimeException();
        return airplaneMapper.mapp(airplaneRepository.save(airplaneMapper.mapp(airplaneDto)));
    }

    @Override
    public List<AirplaneDto> findAllPlanes() {

        return airplaneMapper.mapp(airplaneRepository.findAll());
    }

    @Override
    public Optional<AirplaneDto> getAirplaneById(Long id) {
        return airplaneMapper.mapp(airplaneRepository.findById(id));
    }

    @Override
    public void deleteById(Long id) {
        airplaneRepository.deleteById(id);
    }
}
