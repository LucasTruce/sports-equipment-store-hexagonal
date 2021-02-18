package pl.equipment.store.domain.order.port.out;

import pl.equipment.store.domain.order.dto.OrderDto;

public interface OrderCommand {
    OrderDto createOrder(String status);
}
