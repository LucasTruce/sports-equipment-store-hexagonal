package pl.equipment.store.domain.order.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class SaveOrderDto {
    private final Long id;
    private final String status;
    private final BigDecimal totalPrice;
    private final Long userId;
}
