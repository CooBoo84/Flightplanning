package se.iths.flightplanning.dto;

import se.iths.flightplanning.entity.CustomerEntity;

import javax.persistence.ManyToMany;
import java.util.Set;

public class RoleDto {

    private Long id;
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<CustomerDto> users;

    public RoleDto(String role) {
        this.role = role;
    }

    public RoleDto() {
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

    public Set<CustomerDto> getUsers() {
        return users;
    }

    public void setUsers(Set<CustomerDto> users) {
        this.users = users;
    }
}
