package se.iths.flightplanning.service;

import org.springframework.stereotype.Service;
import se.iths.flightplanning.dto.FoodDto;
import se.iths.flightplanning.mappers.FoodMapper;
import se.iths.flightplanning.repository.FoodRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService implements FoodServiceDto {

    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public FoodService(FoodRepository foodRepository, FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    @Override
    public FoodDto createFood(FoodDto foodDto) {
        if (foodDto.getFood().isEmpty())
            throw new RuntimeException();
        return foodMapper.mapp(foodRepository.save(foodMapper.mapp(foodDto)));
    }

    @Override
    public void deleteFoodById(Long id) {

    }

    @Override
    public List<FoodDto> findAllFood() {
        return foodMapper.mapp(foodRepository.findAll());
    }

    @Override
    public Optional<FoodDto> getFoodById(Long id) {
        return foodMapper.mapp(foodRepository.findById(id));
    }

}
