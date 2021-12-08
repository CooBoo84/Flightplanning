package se.iths.flightplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "food")
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String food;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RouteEntity foodRoute;


    public FoodEntity(String food) {
        this.food = food;
    }

    public FoodEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
