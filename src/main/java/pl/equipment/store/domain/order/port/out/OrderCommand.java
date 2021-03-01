package pl.equipment.store.domain.order.port.out;

import pl.equipment.store.domain.order.dto.CreateOrderDto;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.dto.UpdateOrderDto;

public interface OrderCommand {
    ResponseOrderDto createOrder(CreateOrderDto createOrderDto);
    ResponseOrderDto updateOrder(ResponseOrderDto responseOrderDto, UpdateOrderDto updateOrderDto);
}
