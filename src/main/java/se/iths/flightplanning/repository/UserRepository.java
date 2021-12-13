package se.iths.flightplanning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.flightplanning.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername (String username);
}
