package se.iths.flightplanning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.flightplanning.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findUserEntityById(long id);

    UserEntity findUserEntityByEmail(String email);

    UserEntity findUserEntityByUsername(String userName);

}
