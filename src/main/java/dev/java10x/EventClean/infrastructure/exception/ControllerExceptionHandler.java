package dev.java10x.EventClean.infrastructure.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateEventExceptions(DuplicateEventException exception) {

        Map<String, String> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Message: ", "Please, insert a valid hashId for your event and try again");

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundEventException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundEventException(NotFoundEventException exception) {

        Map<String, String> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Message: ", "The request event was not found, check the identifyer and try again.");

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
