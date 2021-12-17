package se.iths.flightplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "worker")
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int pilot;
    private int flightAttendant;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AirplaneEntity airplane;

    public WorkerEntity(long id, int pilot, int flightAttendant) {
        this.id = id;
        this.pilot = pilot;
        this.flightAttendant = flightAttendant;
    }

    public WorkerEntity() {
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
    @JsonIgnore
    public AirplaneEntity getAirplane() {
        return airplane;
    }

    public void setAirplane(AirplaneEntity airplane) {
        this.airplane = airplane;
    }
}
