package pl.equipment.store.domain.order.port.out;

import pl.equipment.store.domain.order.dto.ResponseOrderDto;

import java.util.List;

public interface OrderQuery {
    List<ResponseOrderDto> findAllOrders();
}
