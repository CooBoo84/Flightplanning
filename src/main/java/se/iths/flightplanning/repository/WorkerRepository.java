package se.iths.flightplanning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.flightplanning.entity.WorkerEntity;

@Repository
public interface WorkerRepository extends CrudRepository<WorkerEntity, Long> {
//    WorkerEntity findById(long id);
}

