package se.iths.flightplanning.mappers;

import org.springframework.stereotype.Component;
import se.iths.flightplanning.dto.RouteDto;
import se.iths.flightplanning.entity.RouteEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RouteMapper {

    public RouteMapper() {
    }

    public RouteDto mapp(RouteEntity routeEntity) {
        return new RouteDto(routeEntity.getId(), routeEntity.getRouteName());
    }

    public RouteEntity mapp(RouteDto routeDto) {
        return new RouteEntity(routeDto.getId(), routeDto.getRouteName());
    }

    public Optional<RouteDto> mapp(Optional<RouteEntity> optionalRouteEntity) {
        if (optionalRouteEntity.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalRouteEntity.get()));
    }

    public List<RouteDto> mapp(List<RouteEntity> all) {
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}
