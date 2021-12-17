package se.iths.flightplanning.dto;

public class WorkerDto {

    private long id;
    private int pilot;
    private int flightAttendant;

    public WorkerDto(long id, int pilot, int flightAttendant) {
        this.id = id;
        this.pilot = pilot;
        this.flightAttendant = flightAttendant;
    }

    public WorkerDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPilot() {
        return pilot;
    }

    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

    public int getFlightAttendant() {
        return flightAttendant;
    }

    public void setFlightAttendant(int flightAttendant) {
        this.flightAttendant = flightAttendant;
    }
}
