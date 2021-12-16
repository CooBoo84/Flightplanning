package se.iths.flightplanning.mappers;

import org.springframework.stereotype.Component;
import se.iths.flightplanning.dto.AirplaneDto;
import se.iths.flightplanning.entity.AirplaneEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AirplaneMapper {
    public AirplaneMapper() {
    }

    public AirplaneDto mapp(AirplaneEntity airplaneEntity) {
        return new AirplaneDto(airplaneEntity.getId(), airplaneEntity.getAirplaneName(), airplaneEntity.getNumberOfSeat(), airplaneEntity.getNumberOfStaff());
    }

    public AirplaneEntity mapp(AirplaneDto airplaneDto) {
        return new AirplaneEntity(airplaneDto.getId(), airplaneDto.getAirplaneName(), airplaneDto.getNumberOfSeat(), airplaneDto.getNumberOfStaff());
    }

    public Optional<AirplaneDto> mapp(Optional<AirplaneEntity> optionalAirplaneEntity) {
        if(optionalAirplaneEntity.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalAirplaneEntity.get()));
    }

    public List<AirplaneDto> mapp(List<AirplaneEntity> all) {
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }

}
