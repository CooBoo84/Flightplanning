package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.dto.FoodDto;
import se.iths.flightplanning.entity.FoodEntity;
import se.iths.flightplanning.mappers.FoodMapper;
import se.iths.flightplanning.repository.FoodRepository;

import java.util.Optional;

@Service
public class FoodService implements FoodServiceDto {

    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public FoodService(FoodRepository foodRepository, FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    public FoodEntity createFood(FoodEntity foodEntity) {
        if (foodEntity.getFood().isEmpty())
            throw new RuntimeException();
        return foodRepository.save(foodEntity);
    }


    public void deleteFoodById(Long id) {
        foodRepository.deleteById(id);
    }


    public Iterable<FoodEntity> findAllFood() {
        return foodRepository.findAll();
    }

    public Iterable<FoodDto> findAllFoodDTO() {
        return foodMapper.mapp(foodRepository.findAll());
    }


    public Optional<FoodEntity> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

}
