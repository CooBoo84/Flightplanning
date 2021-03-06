package se.iths.flightplanning.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import se.iths.flightplanning.entity.RoleEntity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String username;
    private String password;
    private boolean admin;


    public UserDto(String firstName, String lastName, String email, String telephone, String username, String password, boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    private Set<RoleDto> roles = new HashSet<>();

    public void addRole(RoleDto role) {
        roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRole(RoleEntity role) {
        roles.remove(role);
        role.getUsers().remove(this);
    }

    public UserDto() {
    }

    @JsonIgnore
    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    @JsonIgnore
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
