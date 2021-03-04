package pl.equipment.store.domain.order.port.in;

import io.vavr.control.Either;
import pl.equipment.store.domain.order.dto.OrderResponseError;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.dto.SaveOrderDto;

import java.util.List;

public interface OrderRepository {
    Either<OrderResponseError, ResponseOrderDto> saveOrder(SaveOrderDto saveOrderDto);

    List<ResponseOrderDto> findAllOrders();

    Either<OrderResponseError, ResponseOrderDto> findOrderById(Long id);

}
