package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.FoodDto;

import java.util.List;
import java.util.Optional;

public interface FoodServiceDto {

    List<FoodDto> findAllFood();

    Optional<FoodDto> getFoodById(Long id);

    FoodDto createFood(FoodDto foodDto);

    void deleteFoodById(Long id);
}

