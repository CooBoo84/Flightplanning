package se.iths.flightplanning.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ErrorDetails {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    private String message;

    public ErrorDetails(Date timestamp, String message) {
        super();
        this.timestamp = timestamp;
        this.message = message;

    }

    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
