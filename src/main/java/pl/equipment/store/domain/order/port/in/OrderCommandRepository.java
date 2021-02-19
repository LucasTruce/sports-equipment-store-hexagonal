package pl.equipment.store.domain.order.port.in;

import pl.equipment.store.domain.order.dto.CreateOrderDto;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;

public interface OrderCommandRepository {
    ResponseOrderDto saveOrder(CreateOrderDto createOrderDto);
}
