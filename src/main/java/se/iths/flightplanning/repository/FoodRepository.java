package se.iths.flightplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.flightplanning.dto.FoodDto;
import se.iths.flightplanning.entity.FoodEntity;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {

    List<FoodEntity> findAllById(long id);

    FoodDto findFoodById(long id);

}
