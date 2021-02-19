package pl.equipment.store.domain.order.port.in;

import pl.equipment.store.domain.order.dto.ResponseOrderDto;

import java.util.List;

public interface OrderQueryRepository {
    List<ResponseOrderDto> findAllOrders();
}
