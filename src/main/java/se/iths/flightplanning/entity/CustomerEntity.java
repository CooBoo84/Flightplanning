package se.iths.flightplanning.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String email;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "customer_routes", joinColumns = { @JoinColumn(name = "customer_id") },
    inverseJoinColumns = { @JoinColumn(name = "route_id") })
    private Set<RouteEntity> routeNames = new HashSet<>();

    public void addRoute(RouteEntity routeName) {
        routeNames.add(routeName);
        routeName.getUsers().add(this);
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "customer_roles",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<RoleEntity> roles = new HashSet<>();

    public CustomerEntity(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public CustomerEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public Set<RouteEntity> getRouteNames() {
        return routeNames;
    }

    public void setRouteNames(Set<RouteEntity> routeNames) {
        this.routeNames = routeNames;
    }
}
