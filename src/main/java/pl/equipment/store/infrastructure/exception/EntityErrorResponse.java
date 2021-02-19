package pl.equipment.store.infrastructure.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class EntityErrorResponse {
    private final int status;
    private final String message;
    private final LocalDateTime timestamp;
}
