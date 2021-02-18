package pl.equipment.store.domain.order.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class OrderDto {
    private final Long id;
    private final String status;
    private final LocalDateTime date;
}
