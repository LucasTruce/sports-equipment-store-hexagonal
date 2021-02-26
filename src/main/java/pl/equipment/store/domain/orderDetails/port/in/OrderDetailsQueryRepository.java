package pl.equipment.store.domain.orderDetails.port.in;

import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;

import java.util.List;

public interface OrderDetailsQueryRepository {
    List<OrderDetailsResponseDto> findAllOrderDetails();
}
