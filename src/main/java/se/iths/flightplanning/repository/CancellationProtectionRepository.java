package se.iths.flightplanning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.flightplanning.entity.CancellationProtectionEntity;

@Repository
public interface CancellationProtectionRepository extends CrudRepository<CancellationProtectionEntity,Long> {
    CancellationProtectionEntity findById(long id);

    void deleteById(long id);

    //void deleteByProtection(String protection);

}
