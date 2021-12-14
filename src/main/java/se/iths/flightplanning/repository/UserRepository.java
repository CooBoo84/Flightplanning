package se.iths.flightplanning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.flightplanning.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail (String email);

    UserEntity findById(long id);

    boolean deleteById(long id);

    //void deleteByEmail(String email);
}
