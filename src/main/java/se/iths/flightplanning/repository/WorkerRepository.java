package se.iths.flightplanning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.flightplanning.entity.AirplaneEntity;
import se.iths.flightplanning.entity.WorkerEntity;

@Repository
public interface WorkerRepository extends CrudRepository<WorkerEntity, Long> {
    WorkerEntity findById(long id);

    WorkerEntity findByAirplane_AirplaneName(String airplaneName);

    void deleteById(long id);

    //void deleteByPilot(int pilot);
    //void deleteByFlightAttendant(int flightAttendant);
}
