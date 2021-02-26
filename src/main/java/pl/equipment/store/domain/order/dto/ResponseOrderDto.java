package pl.equipment.store.domain.order.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ResponseOrderDto {
    private final Long id;
    private final String status;
    private final double totalPrice;
    private final Long userId;
}
