package pl.equipment.store.domain.order.port.out;

import io.vavr.control.Either;
import pl.equipment.store.domain.order.dto.OrderResponseError;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;

import java.util.List;

public interface FindOrder {
    List<ResponseOrderDto> findAll();

    Either<OrderResponseError, ResponseOrderDto> findById(Long id);
}
