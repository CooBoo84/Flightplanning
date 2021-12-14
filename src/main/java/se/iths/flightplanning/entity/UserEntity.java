package se.iths.flightplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;


<<<<<<< HEAD

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RoleEntity> roles = new HashSet<>();
=======
    public UserEntity(String firstName, String lastName, String email, String telephone, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.username = username;
        this.password = password;
    }

    public UserEntity() {
    }

    public void addRoute(RouteEntity routeName) {
        routeNames.add(routeName);
        routeName.getUsers().add(this);
    }
>>>>>>> d705337efabc22873f15df12bfde23dfd2219f3f

    public void addRole(RoleEntity role) {
        roles.add(role);
        role.getUsers().add(this);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}
