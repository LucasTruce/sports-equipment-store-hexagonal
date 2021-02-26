package pl.equipment.store.domain.orderDetails;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsCommandRepository;
import pl.equipment.store.domain.orderDetails.port.out.OrderDetailsCommand;

@RequiredArgsConstructor
class OrderDetailsCommandFacade implements OrderDetailsCommand {

    private final OrderDetailsCommandRepository repository;

    @Override
    public OrderDetailsResponseDto createOrderDetails(CreateOrderDetailsDto createOrderDetailsDto) {
        OrderDetails orderDetails = OrderDetails.create(createOrderDetailsDto.getQuantity(), createOrderDetailsDto.getOrderId(), createOrderDetailsDto.getProductId());
        return repository.saveOrderDetails(OrderDetailsMapper.toOrderDetailsResponseDto(orderDetails));
    }
}
