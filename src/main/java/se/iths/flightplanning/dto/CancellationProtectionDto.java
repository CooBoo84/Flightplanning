package se.iths.flightplanning.dto;


public class CancellationProtectionDto {

    private long id;
    private String protection;


    public CancellationProtectionDto(String protection) {
        this.protection = protection;
    }

    public CancellationProtectionDto() {
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
}
