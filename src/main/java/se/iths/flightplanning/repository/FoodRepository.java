package se.iths.flightplanning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.flightplanning.entity.FoodEntity;

@Repository
public interface FoodRepository extends CrudRepository<FoodEntity, Long> {
    FoodEntity findById(long id);

}
