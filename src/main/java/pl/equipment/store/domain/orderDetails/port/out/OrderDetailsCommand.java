package pl.equipment.store.domain.orderDetails.port.out;


import io.vavr.control.Either;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseError;


public interface OrderDetailsCommand {
    Either<OrderDetailsResponseError, OrderDetailsResponseDto> createOrderDetails(CreateOrderDetailsDto createOrderDetailsDto);
}
