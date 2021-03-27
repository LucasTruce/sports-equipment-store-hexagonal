package pl.equipment.store.domain.order.port.out;

import io.vavr.control.Either;
import pl.equipment.store.domain.order.dto.OrderResponseError;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;

public interface CreateOrder {
    Either<OrderResponseError, ResponseOrderDto> create(Long userId);
}
