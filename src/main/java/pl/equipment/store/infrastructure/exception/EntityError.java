package pl.equipment.store.infrastructure.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class EntityError {
    private final String message;
}
