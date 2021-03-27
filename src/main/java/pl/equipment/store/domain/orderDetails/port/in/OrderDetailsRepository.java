package pl.equipment.store.domain.orderDetails.port.in;

import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.dto.SaveOrderDetailsDto;

import java.util.List;

public interface OrderDetailsRepository {
    OrderDetailsResponseDto save(SaveOrderDetailsDto saveOrderDetailsDto);

    List<OrderDetailsResponseDto> findAll();
}
