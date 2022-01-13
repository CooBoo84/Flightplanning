package se.iths.flightplanning.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<CustomerEntity> users;

    public RoleEntity(String role) {
        this.role = role;
    }

    public RoleEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<CustomerEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<CustomerEntity> users) {
        this.users = users;
    }
}
