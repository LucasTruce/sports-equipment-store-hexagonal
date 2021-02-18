package pl.equipment.store.domain.order.port.in;

import pl.equipment.store.domain.order.dto.OrderDto;

public interface OrderCommandRepository {
    OrderDto saveOrder(OrderDto orderDto);
}
