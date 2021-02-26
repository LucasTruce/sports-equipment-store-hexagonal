package pl.equipment.store.domain.orderDetails.port.in;

import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;

public interface OrderDetailsCommandRepository {
    OrderDetailsResponseDto saveOrderDetails(OrderDetailsResponseDto orderDetailsResponseDto);
}
