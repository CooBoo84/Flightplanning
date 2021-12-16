package se.iths.flightplanning.dto;

public class RoleDto {

    private Long id;
    private String role;


    public RoleDto(Long id, String role) {
        this.id = id;
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
}