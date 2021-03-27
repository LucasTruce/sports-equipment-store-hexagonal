package pl.equipment.store.infrastructure.orderDetails;

import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.dto.SaveOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsRepository;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryOrderDetailsRepository implements OrderDetailsRepository {

    ConcurrentHashMap<Long, OrderDetailsEntity> hashMap = new ConcurrentHashMap<>();

    @Override
    public OrderDetailsResponseDto save(SaveOrderDetailsDto saveOrderDetailsDto) {
        OrderDetailsEntity entity = OrderDetailsMapper.toOrderDetailsEntity(saveOrderDetailsDto);
        hashMap.put(new Random().nextLong(), entity);
        return OrderDetailsMapper.toOrderDetailsResponseDto(entity);
    }

    @Override
    public List<OrderDetailsResponseDto> findAll() {
        return hashMap.values()
                .stream()
                .map(OrderDetailsMapper::toOrderDetailsResponseDto)
                .collect(Collectors.toList());
    }
}
