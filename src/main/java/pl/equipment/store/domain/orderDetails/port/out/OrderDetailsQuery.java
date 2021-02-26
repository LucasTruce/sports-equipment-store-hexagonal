package pl.equipment.store.domain.orderDetails.port.out;

import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;

import java.util.List;

public interface OrderDetailsQuery {
    List<OrderDetailsResponseDto> findAllOrderDetails();
}
