package pl.equipment.store.domain.order.port.out;

import io.vavr.control.Either;
import pl.equipment.store.domain.order.dto.CreateOrderDto;
import pl.equipment.store.domain.order.dto.OrderResponseError;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;

public interface OrderCommand {
    Either<OrderResponseError, ResponseOrderDto> createOrder(CreateOrderDto createOrderDto);
}
