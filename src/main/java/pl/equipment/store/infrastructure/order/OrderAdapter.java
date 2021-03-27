package pl.equipment.store.infrastructure.order;

import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.dto.SaveOrderDto;
import pl.equipment.store.domain.order.port.in.OrderRepository;
import pl.equipment.store.domain.orderDetails.port.in.OrderDatabase;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class OrderAdapter implements OrderRepository, OrderDatabase {

    private final OrderSpringRepository repository;

    @Override
    public ResponseOrderDto save(SaveOrderDto saveOrderDto) {
        OrderEntity orderEntity = OrderMapper.toEntity(saveOrderDto);
        return OrderMapper.toResponseOrderDto(repository.save(orderEntity));
    }

    @Override
    public List<ResponseOrderDto> findAll() {
        return repository.findAll()
                .stream()
                .map(OrderMapper::toResponseOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public Option<ResponseOrderDto> findById(Long id) {
        return Option.ofOptional(repository.findById(id).map(OrderMapper::toResponseOrderDto));
    }

    @Override
    public Option<BigDecimal> getTotalPrice(Long orderId) {
        return Option.ofOptional(repository.findById(orderId)
                .map(OrderEntity::getTotalPrice));
    }

    @Override
    public Option<Long> updateTotalPrice(Long id, BigDecimal totalPrice) {
        Optional<OrderEntity> optionalOrderEntity = repository.findById(id);
        optionalOrderEntity.ifPresent(order -> order.setTotalPrice(totalPrice));
        return Option.ofOptional(optionalOrderEntity.map(OrderEntity::getId));

    }
}
