package se.iths.flightplanning.dto;


public class AirplaneDto {

    private long id;
    private String airplaneName;
    private int numberOfSeat;
    private int numberOfStaff;

    public AirplaneDto(long id, String airplaneName, int numberOfSeat, int numberOfStaff) {
        this.id = id;
        this.airplaneName = airplaneName;
        this.numberOfSeat = numberOfSeat;
        this.numberOfStaff = numberOfStaff;
    }

    public AirplaneDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public int getNumberOfStaff() {
        return numberOfStaff;
    }

    public void setNumberOfStaff(int numberOfStaff) {
        this.numberOfStaff = numberOfStaff;
    }
}
