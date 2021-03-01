package pl.equipment.store.infrastructure.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.port.in.OrderRepository;
import pl.equipment.store.infrastructure.user.UserEntity;
import pl.equipment.store.infrastructure.user.UserSpringRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class OrderAdapter implements OrderRepository {

    private final OrderSpringRepository repository;
    private final UserSpringRepository userRepository;

    @Override
    public ResponseOrderDto saveOrder(ResponseOrderDto responseOrderDto) {
        OrderEntity orderEntity = OrderEntity.toOrderEntity(responseOrderDto);
        UserEntity userEntity = userRepository.findById(responseOrderDto.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found!"));
        orderEntity.setUserEntity(userEntity);
        return OrderEntity.toResponseOrderDto(repository.save(orderEntity));
    }

    @Override
    public List<ResponseOrderDto> findAllOrders() {
        return repository.findAll()
                .stream()
                .map(OrderEntity::toResponseOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseOrderDto findOrderById(Long id) {
        return OrderEntity.toResponseOrderDto(
                repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found!")));
    }
}
