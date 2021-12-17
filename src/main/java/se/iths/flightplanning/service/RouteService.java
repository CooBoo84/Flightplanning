package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.dto.RouteDto;
import se.iths.flightplanning.entity.RouteEntity;
import se.iths.flightplanning.mappers.RouteMapper;
import se.iths.flightplanning.repository.RouteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService implements RouteServiceDto {

    private final RouteRepository routeRepository;
    private final RouteMapper routeMapper;

    public RouteService(RouteRepository routeRepository, RouteMapper routeMapper) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
    }

    @Override
    public List<RouteDto> findAllRoutes() {
        return routeMapper.mapp(routeRepository.findAll());
    }

    @Override
    public Optional<RouteDto> getRouteByid(Long id) {
        return routeMapper.mapp(routeRepository.findById(id));
    }

    @Override
    public RouteDto createRoute(RouteDto routeDto) {
        if(routeDto.getRouteName().isEmpty())
            throw new RuntimeException();

        return routeMapper.mapp(routeRepository.save(routeMapper.mapp(routeDto)));
    }

    @Override
    public void deleteRouteById(Long id) {
        routeRepository.deleteById(id);

    }
}
