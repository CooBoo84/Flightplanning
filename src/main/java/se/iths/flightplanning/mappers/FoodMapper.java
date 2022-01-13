package se.iths.flightplanning.mappers;

import org.springframework.stereotype.Component;
import se.iths.flightplanning.dto.FoodDto;
import se.iths.flightplanning.entity.FoodEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FoodMapper {


    public FoodMapper() {
    }

    public FoodDto mapp(FoodEntity foodEntity) {
        return new FoodDto(foodEntity.getFood());
    }

    public FoodEntity mapp(FoodDto foodDto) {
        return new FoodEntity(foodDto.getFood());
    }

    public Optional<FoodDto> mapp(Optional<FoodEntity> optionalFoodEntity) {
        if (optionalFoodEntity.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalFoodEntity.get()));
    }

    public List<FoodDto> mapp(List<FoodEntity> all) {
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}