package se.iths.flightplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "cancellationprotection")
public class CancellationProtectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String protection;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RouteEntity route;

    public CancellationProtectionEntity(long id, String protection) {
        this.id = id;
        this.protection = protection;
    }

    public CancellationProtectionEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProtection() {
        return protection;
    }

    public void setProtection(String protection) {
        this.protection = protection;
    }

    @JsonIgnore
    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }
}
