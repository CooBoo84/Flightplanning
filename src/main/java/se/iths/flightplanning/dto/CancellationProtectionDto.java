package se.iths.flightplanning.dto;


public class CancellationProtectionDto {

    private Long id;
    private String protection;


    public CancellationProtectionDto(Long id, String protection) {
        this.id = id;
        this.protection = protection;
    }

    public CancellationProtectionDto() {
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
}
