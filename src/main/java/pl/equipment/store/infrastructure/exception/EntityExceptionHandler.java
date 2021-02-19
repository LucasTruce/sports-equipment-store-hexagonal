package pl.equipment.store.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@ControllerAdvice
public class EntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> EntityNotFound(EntityNotFoundException ex) {
        EntityErrorResponse postErrorRes = new EntityErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(postErrorRes, HttpStatus.NOT_FOUND);
    }
}
