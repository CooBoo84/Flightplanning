package se.iths.flightplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.flightplanning.entity.RouteEntity;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {

    RouteEntity findByRouteName(String routeName);

    void deleteById(long id);



    //void deleteByRouteName(String routeName);
}
