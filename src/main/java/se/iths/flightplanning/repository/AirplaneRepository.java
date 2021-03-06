package se.iths.flightplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.flightplanning.entity.AirplaneEntity;

@Repository
public interface AirplaneRepository extends JpaRepository<AirplaneEntity, Long> {


}
