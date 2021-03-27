package pl.equipment.store.domain.order.port.in;

import io.vavr.control.Option;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.dto.SaveOrderDto;

import java.util.List;

public interface OrderRepository {
    ResponseOrderDto save(SaveOrderDto saveOrderDto);

    List<ResponseOrderDto> findAll();

    Option<ResponseOrderDto> findById(Long id);
}
