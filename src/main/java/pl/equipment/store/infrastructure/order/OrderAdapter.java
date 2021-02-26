package pl.equipment.store.infrastructure.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
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
class OrderAdapter implements OrderCommandRepository, OrderQueryRepository {

    private final OrderSpringRepository repository;
    private final UserSpringRepository userRepository;

    @Override
    public ResponseOrderDto saveOrder(ResponseOrderDto responseOrderDto) {
        OrderEntity orderEntity = OrderEntity.EntityFactory.toOrderEntity(responseOrderDto);
        UserEntity userEntity = userRepository.findById(responseOrderDto.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found!"));
        orderEntity.setUserEntity(userEntity);
        return OrderEntity.EntityFactory.toResponseOrderDto(repository.save(orderEntity));
    }

    @Override
    public List<ResponseOrderDto> findAllOrders() {
        return repository.findAll()
                .stream()
                .map(OrderEntity.EntityFactory::toResponseOrderDto)
                .collect(Collectors.toList());
    }
}
