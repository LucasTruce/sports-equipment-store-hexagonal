package pl.equipment.store.infrastructure.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Getter
public class NotValidErrorResponse {
    private final int status;
    private final List<EntityError> errors;
    private final LocalDateTime timestamp;
}
