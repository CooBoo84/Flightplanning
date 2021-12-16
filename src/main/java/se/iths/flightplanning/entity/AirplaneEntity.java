package se.iths.flightplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "airplane")
public class AirplaneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String airplaneName;
    private int numberOfSeat;
    private int numberOfStaff;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RouteEntity planeNames;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<WorkerEntity> staff = new HashSet<>();

    public AirplaneEntity(long id, String airplaneName, int numberOfSeat, int numberOfStaff) {
        this.id = id;
        this.airplaneName = airplaneName;
        this.numberOfSeat = numberOfSeat;
        this.numberOfStaff = numberOfStaff;
    }

    public AirplaneEntity() {
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

    @JsonIgnore
    public RouteEntity getPlaneNames() {
        return planeNames;
    }

    public void setPlaneNames(RouteEntity planeNames) {
        this.planeNames = planeNames;
    }

    public Set<WorkerEntity> getStaff() {
        return staff;
    }

    public void setStaff(Set<WorkerEntity> staff) {
        this.staff = staff;
    }
}
