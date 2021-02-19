package pl.equipment.store.infrastructure.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.order.dto.CreateOrderDto;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.port.in.OrderCommandRepository;
import pl.equipment.store.domain.order.port.in.OrderQueryRepository;
import pl.equipment.store.infrastructure.user.UserEntity;
import pl.equipment.store.infrastructure.user.UserSpringRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class OrderAdapter implements OrderCommandRepository, OrderQueryRepository {

    private final OrderSpringRepository repository;
    private final UserSpringRepository userRepository;

    @Override
    public ResponseOrderDto saveOrder(CreateOrderDto createOrderDto) {
        OrderEntity orderEntity = OrderEntity.EntityFactory.toOrderEntity(createOrderDto);
        UserEntity userEntity = userRepository.findById(createOrderDto.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found!"));
        orderEntity.setUserEntity(userEntity);
        repository.save(orderEntity);
        return OrderEntity.EntityFactory.toResponseOrderDto(orderEntity);
    }

    @Override
    public List<ResponseOrderDto> findAllOrders() {
        return repository.findAll()
                .stream()
                .map(OrderEntity.EntityFactory::toResponseOrderDto)
                .collect(Collectors.toList());
    }
}
