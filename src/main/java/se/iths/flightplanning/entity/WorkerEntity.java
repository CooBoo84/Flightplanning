package se.iths.flightplanning.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

// Should we rename WorkerEntity to Crew and
// pilot -> numberOfPilots,
// flightAttendant -> numberOfFlightAttendants

@Entity
@Table(name = "worker")
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int pilot;
    private int flightAttendant;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AirplaneEntity airplane;

    public WorkerEntity(int pilot, int flightAttendant) {
        this.pilot = pilot;
        this.flightAttendant = flightAttendant;
    }

    public WorkerEntity() {
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
    @JsonIgnore
    public AirplaneEntity getAirplane() {
        return airplane;
    }

    public void setAirplane(AirplaneEntity airplane) {
        this.airplane = airplane;
    }
}
