package pl.equipment.store.infrastructure.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.order.dto.OrderDto;
import pl.equipment.store.domain.order.port.in.OrderCommandRepository;
import pl.equipment.store.domain.order.port.in.OrderQueryRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class OrderAdapter implements OrderCommandRepository, OrderQueryRepository {

    private final OrderSpringRepository repository;

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        OrderEntity orderEntity = repository.save(OrderEntity.EntityFactory.toOrderEntity(orderDto));
        return OrderEntity.EntityFactory.toOrderDto(orderEntity);
    }

    @Override
    public List<OrderDto> findAllOrders() {
        return repository.findAll()
                .stream()
                .map(OrderEntity.EntityFactory::toOrderDto)
                .collect(Collectors.toList());
    }
}
