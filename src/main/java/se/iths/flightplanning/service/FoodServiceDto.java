package se.iths.flightplanning.service;

import se.iths.flightplanning.dto.FoodDto;

public interface FoodServiceDto {

    Iterable<FoodDto> findAllFoodDTO();
    void deleteFoodById(Long id);
}
