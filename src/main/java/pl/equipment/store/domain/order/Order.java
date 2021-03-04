package pl.equipment.store.domain.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.equipment.store.domain.order.dto.CreateOrderDto;
import pl.equipment.store.domain.order.dto.SaveOrderDto;

import java.math.BigDecimal;


@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter
class Order {
    private Long id;
    private String status;
    private BigDecimal totalPrice;
    private Long userId;

    static SaveOrderDto create(CreateOrderDto createOrderDto) {
        Order order = OrderMapper.toOrder(createOrderDto);
        order.setStatus("NEW_ORDER");
        order.setTotalPrice(BigDecimal.valueOf(0L));
        return OrderMapper.toSaveOrderDto(order);
    }

}
