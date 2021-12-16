package se.iths.flightplanning.dto;


public class RouteDto {

    private Long id;
    private String routeName;


    public RouteDto(Long id, String routeName) {
        this.id = id;
        this.routeName = routeName;
    }

    public RouteDto() {
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
}
