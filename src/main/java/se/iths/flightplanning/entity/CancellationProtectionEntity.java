package se.iths.flightplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

//String protection -> boolean
@Entity
public class CancellationProtectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String protection;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RouteEntity route;

    public CancellationProtectionEntity(String protection) {
        this.protection = protection;
    }

    public CancellationProtectionEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
