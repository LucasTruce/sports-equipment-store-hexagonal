package pl.equipment.store.domain.orderDetails.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class OrderDetailsResponseError {
    private final String message;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
