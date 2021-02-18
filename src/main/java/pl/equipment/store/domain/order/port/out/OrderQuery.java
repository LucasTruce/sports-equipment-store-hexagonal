package pl.equipment.store.domain.order.port.out;

import pl.equipment.store.domain.order.dto.OrderDto;

import java.util.List;

public interface OrderQuery {
    List<OrderDto> findAllOrders();
}
