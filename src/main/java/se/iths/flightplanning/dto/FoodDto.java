package se.iths.flightplanning.dto;


public class FoodDto {

    private long id;
    private String food;

    public FoodDto(String food) {
        this.food = food;
    }

    public FoodDto() {
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
}