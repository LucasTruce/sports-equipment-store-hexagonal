package pl.equipment.store.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class EntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> EntityNotFound(EntityNotFoundException ex) {
        EntityErrorResponse postErrorRes = new EntityErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(postErrorRes, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<NotValidErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<EntityError> entityErrors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            entityErrors.add(new EntityError("Field [" + fieldName + "] " + errorMessage));
        });

        NotValidErrorResponse response = new NotValidErrorResponse(HttpStatus.BAD_REQUEST.value(), entityErrors, LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
