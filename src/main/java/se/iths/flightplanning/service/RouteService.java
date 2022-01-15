package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.dto.RouteDto;
import se.iths.flightplanning.entity.RouteEntity;
import se.iths.flightplanning.mappers.RouteMapper;
import se.iths.flightplanning.repository.RouteRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class RouteService implements RouteServiceDto {

    private final RouteRepository routeRepository;
    private final RouteMapper routeMapper;

    public RouteService(RouteRepository routeRepository, RouteMapper routeMapper) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
    }

    public Iterable<RouteEntity> findAllRoutes() {
        return routeRepository.findAll();
    }

    public Iterable<RouteDto> findAllRoutesDto() {
        return routeMapper.mapp(routeRepository.findAll());
    }

    public Optional<RouteEntity> getRouteById(Long id) {
        return routeRepository.findById(id);
    }

    public RouteEntity createRoute(RouteEntity routeEntity) {
        if(routeEntity.getRouteName().isEmpty())
            throw new RuntimeException();

        return routeRepository.save(routeEntity);
    }

    public void deleteRouteById(Long id) {
        RouteEntity foundRoute = routeRepository.findById(id).orElseThrow(EntityNotFoundException::new);  //Optional förhindrar nullpointExceptions
        routeRepository.deleteById(foundRoute.getId());

    }
}
