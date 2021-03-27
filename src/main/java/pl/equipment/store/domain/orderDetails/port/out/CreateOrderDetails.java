package pl.equipment.store.domain.orderDetails.port.out;


import io.vavr.control.Either;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseError;


public interface CreateOrderDetails {
    Either<OrderDetailsResponseError, OrderDetailsResponseDto> create(CreateOrderDetailsDto createOrderDetailsDto);
}
