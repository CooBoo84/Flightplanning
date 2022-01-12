package se.iths.flightplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "route")
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String routeName;


    @ManyToMany(mappedBy = "routeNames", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CustomerEntity> users;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AirplaneEntity> airplaneNames = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private FoodEntity foods;


    public RouteEntity(String routeName) {
        this.routeName = routeName;
    }

    public RouteEntity() {
    }


    public Set<AirplaneEntity> getAirplaneNames() {
        return airplaneNames;
    }

    public void setAirplaneNames(Set<AirplaneEntity> airplaneNames) {
        this.airplaneNames = airplaneNames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    @JsonIgnore
    public Set<CustomerEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<CustomerEntity> users) {
        this.users = users;
    }

    public FoodEntity getFood() {
        return foods;
    }

    public void setFood(FoodEntity foods) {
        this.foods = foods;
    }
}
