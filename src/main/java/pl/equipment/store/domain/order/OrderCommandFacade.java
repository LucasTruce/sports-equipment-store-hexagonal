package pl.equipment.store.domain.order;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.order.dto.CreateOrderDto;
import pl.equipment.store.domain.order.dto.OrderResponseError;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.port.in.OrderRepository;
import pl.equipment.store.domain.order.port.out.OrderCommand;


@RequiredArgsConstructor
class OrderCommandFacade implements OrderCommand {

    private final OrderRepository orderRepository;

    @Override
    public Either<OrderResponseError, ResponseOrderDto> createOrder(CreateOrderDto createOrderDto) {
        return orderRepository.saveOrder(Order.create(createOrderDto));
    }

}
