package pl.equipment.store.domain.order;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.order.dto.CreateOrderDto;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.port.in.OrderCommandRepository;
import pl.equipment.store.domain.order.port.out.OrderCommand;

@RequiredArgsConstructor
class OrderCommandFacade implements OrderCommand {

    private final OrderCommandRepository commandRepository;

    @Override
    public ResponseOrderDto createOrder(CreateOrderDto createOrderDto) {
        Order order = Order.create(createOrderDto.getStatus(), createOrderDto.getUserId());
        return commandRepository.saveOrder(OrderMapper.toResponseOrderDto(order));
    }
}
