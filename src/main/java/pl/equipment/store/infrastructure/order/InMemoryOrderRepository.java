package pl.equipment.store.infrastructure.order;

import io.vavr.control.Option;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.dto.SaveOrderDto;
import pl.equipment.store.domain.order.port.in.OrderRepository;
import pl.equipment.store.domain.orderDetails.port.in.OrderDatabase;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryOrderRepository implements OrderRepository, OrderDatabase {
    ConcurrentHashMap<Long, OrderEntity> hashMap = new ConcurrentHashMap<>();


    @Override
    public ResponseOrderDto save(SaveOrderDto saveOrderDto) {
        OrderEntity entity = OrderMapper.toEntity(saveOrderDto);
        hashMap.put(entity.getId(), entity);
        return OrderMapper.toResponseOrderDto(entity);
    }

    @Override
    public List<ResponseOrderDto> findAll() {
        return hashMap.values().stream().map(OrderMapper::toResponseOrderDto).collect(Collectors.toList());
    }

    @Override
    public Option<ResponseOrderDto> findById(Long id) {
        return Option.of(OrderMapper.toResponseOrderDto(hashMap.get(id)));
    }

    @Override
    public Option<BigDecimal> getTotalPrice(Long orderId) {
        return Option.of(hashMap.get(orderId).getTotalPrice());
    }

    @Override
    public Option<Long> updateTotalPrice(Long id, BigDecimal totalPrice) {
        OrderEntity entity = hashMap.get(id);
        entity.setTotalPrice(totalPrice);
        hashMap.put(id, entity);
        return Option.of(hashMap.get(id).getId());
    }
}
