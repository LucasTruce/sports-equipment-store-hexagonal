package pl.equipment.store.domain.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.order.dto.SaveOrderDto;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
class Order {
    private final Long id;
    private final String status;
    private final BigDecimal totalPrice;
    private final Long userId;

    static SaveOrderDto create(Long userId) {
        return new SaveOrderDto(null, "NEW_ORDER", BigDecimal.valueOf(0L), userId);
    }
}
