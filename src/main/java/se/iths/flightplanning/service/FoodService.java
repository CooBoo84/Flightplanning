package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.entity.FoodEntity;
import se.iths.flightplanning.repository.FoodRepository;

import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
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


    public Optional<FoodEntity> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

}
