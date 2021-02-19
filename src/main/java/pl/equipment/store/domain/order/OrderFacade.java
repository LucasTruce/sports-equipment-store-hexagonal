package pl.equipment.store.domain.order;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.order.dto.CreateOrderDto;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.port.in.OrderCommandRepository;
import pl.equipment.store.domain.order.port.in.OrderQueryRepository;
import pl.equipment.store.domain.order.port.out.OrderCommand;
import pl.equipment.store.domain.order.port.out.OrderQuery;

import java.util.List;

@RequiredArgsConstructor
class OrderFacade implements OrderCommand, OrderQuery {

    private final OrderCommandRepository commandRepository;
    private final OrderQueryRepository queryRepository;

    @Override
    public ResponseOrderDto createOrder(CreateOrderDto createOrderDto) {
        Order order = Order.create(createOrderDto.getStatus(), createOrderDto.getTotalPrice(), createOrderDto.getUserId());
        return commandRepository.saveOrder(OrderMapper.toOrderDto(order));
    }

    @Override
    public List<ResponseOrderDto> findAllOrders() {
        return queryRepository.findAllOrders();
    }
}
