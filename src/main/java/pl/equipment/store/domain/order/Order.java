package pl.equipment.store.domain.order;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.order.dto.SaveOrderDto;

import java.math.BigDecimal;

@RequiredArgsConstructor
class Order {
    private final Long id;
    private final String status;
    private final BigDecimal totalPrice;
    private final Long userId;

    static Order create(Long userId) {
        return new Order(null, "NEW_ORDER", BigDecimal.valueOf(0L), userId);
    }

    SaveOrderDto toSaveOrderDto() {
        return new SaveOrderDto(id, status, totalPrice, userId);
    }
}
