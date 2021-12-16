package se.iths.flightplanning.dto;


public class FoodDto {

    private Long id;
    private String food;

    public FoodDto(Long id, String food) {
        this.id = id;
        this.food = food;
    }

    public FoodDto() {
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
}
