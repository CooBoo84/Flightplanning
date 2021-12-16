package se.iths.flightplanning.dto;

public class WorkerDto {

    private Long id;
    private int pilot;
    private int flightAttendant;

    public WorkerDto(Long id, int pilot, int flightAttendant) {
        this.id = id;
        this.pilot = pilot;
        this.flightAttendant = flightAttendant;
    }

    public WorkerDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
