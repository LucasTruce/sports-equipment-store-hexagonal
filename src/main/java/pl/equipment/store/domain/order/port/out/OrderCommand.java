package pl.equipment.store.domain.order.port.out;

import pl.equipment.store.domain.order.dto.CreateOrderDto;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;

public interface OrderCommand {
    ResponseOrderDto createOrder(CreateOrderDto createOrderDto);
}
