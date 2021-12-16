package se.iths.flightplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.flightplanning.entity.AirplaneEntity;
import se.iths.flightplanning.entity.CancellationProtectionEntity;

import java.util.List;

@Repository
public interface CancellationProtectionRepository extends JpaRepository<CancellationProtectionEntity,Long> {
    CancellationProtectionEntity findById(long id);
}
