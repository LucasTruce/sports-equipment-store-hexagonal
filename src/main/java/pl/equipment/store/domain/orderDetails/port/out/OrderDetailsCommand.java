package pl.equipment.store.domain.orderDetails.port.out;


import io.vavr.control.Either;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsError;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;


public interface OrderDetailsCommand {
    Either<OrderDetailsError, OrderDetailsResponseDto> createOrderDetails(CreateOrderDetailsDto createOrderDetailsDto);
}
