package se.iths.flightplanning.dto;

import javax.persistence.ManyToMany;
import java.util.Set;

public class RoleDto {

    private Long id;
    private String role;

    private Set<UserDto> users;

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

    public Set<UserDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDto> users) {
        this.users = users;
    }
}
