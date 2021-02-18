package pl.equipment.store.domain.order.port.in;

import pl.equipment.store.domain.order.dto.OrderDto;

import java.util.List;

public interface OrderQueryRepository {
    List<OrderDto> findAllOrders();
}
