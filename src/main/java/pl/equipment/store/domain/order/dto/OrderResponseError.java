package pl.equipment.store.domain.order.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class OrderResponseError {
    private final String message;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
