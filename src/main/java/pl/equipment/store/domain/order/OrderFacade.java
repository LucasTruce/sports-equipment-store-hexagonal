package pl.equipment.store.domain.order;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.order.dto.OrderDto;
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
    public OrderDto createOrder(String status) {
        Order order = Order.create(status);
        return commandRepository.saveOrder(OrderMapper.toOrderDto(order));
    }

    @Override
    public List<OrderDto> findAllOrders() {
        return queryRepository.findAllOrders();
    }
}
