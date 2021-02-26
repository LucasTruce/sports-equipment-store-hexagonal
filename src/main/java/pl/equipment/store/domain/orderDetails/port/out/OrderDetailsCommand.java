package pl.equipment.store.domain.orderDetails.port.out;

import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;


public interface OrderDetailsCommand {
    OrderDetailsResponseDto createOrderDetails(CreateOrderDetailsDto createOrderDetailsDto);
}
