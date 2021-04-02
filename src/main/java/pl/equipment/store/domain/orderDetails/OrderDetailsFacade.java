package pl.equipment.store.domain.orderDetails;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseError;
import pl.equipment.store.domain.orderDetails.port.out.CreateOrderDetails;
import pl.equipment.store.domain.orderDetails.port.out.FindOrderDetails;

import java.util.List;

@RequiredArgsConstructor
class OrderDetailsFacade implements CreateOrderDetails, FindOrderDetails {

    private final OrderDetailsService service;

    @Override
    public Either<OrderDetailsResponseError, OrderDetailsResponseDto> create(CreateOrderDetailsDto createOrderDetailsDto) {
        return service.create(createOrderDetailsDto);
    }

    @Override
    public List<OrderDetailsResponseDto> findAll() {
        return service.findAll();
    }
}
