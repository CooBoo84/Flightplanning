package se.iths.flightplanning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SEE_OTHER)
public class EmptyListException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public EmptyListException(String message) {
        super(message);
    }
}
