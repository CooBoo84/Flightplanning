package se.iths.flightplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "food")
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String food;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RouteEntity foodRoute;


    public FoodEntity(long id, String food) {
        this.food = food;
    }

    public FoodEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
    @JsonIgnore
    public RouteEntity getFoodRoute() {
        return foodRoute;
    }

    public void setFoodRoute(RouteEntity foodRoute) {
        this.foodRoute = foodRoute;
    }


}
