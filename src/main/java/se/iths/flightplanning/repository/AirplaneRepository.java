package se.iths.flightplanning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.flightplanning.entity.AirplaneEntity;

@Repository
public interface AirplaneRepository extends CrudRepository<AirplaneEntity, Long> {

    AirplaneEntity findAirplaneEntityById(long id);

    AirplaneEntity findByAirplaneName(String airplaneName);

    void deleteAirplaneEntityById(long id);

    void deleteAirplaneEntityByAirplaneName(String airplaneName);

}
