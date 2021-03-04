package pl.equipment.store.infrastructure.order;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.order.dto.OrderResponseError;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.dto.SaveOrderDto;
import pl.equipment.store.domain.order.port.in.OrderRepository;
import pl.equipment.store.infrastructure.user.UserSpringRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class OrderAdapter implements OrderRepository {

    private final OrderSpringRepository repository;
    private final UserSpringRepository userRepository;

    @Override
    public Either<OrderResponseError, ResponseOrderDto> saveOrder(SaveOrderDto saveOrderDto) {
        OrderEntity orderEntity = OrderEntity.toOrderEntity(saveOrderDto);

        if (userRepository.existsById(saveOrderDto.getUserId()))
            return Either.right(OrderEntity.toResponseOrderDto(repository.save(orderEntity)));
        return Either.left(new OrderResponseError("User not found", LocalDateTime.now()));
    }

    @Override
    public List<ResponseOrderDto> findAllOrders() {
        return repository.findAll()
                .stream()
                .map(OrderEntity::toResponseOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public Either<OrderResponseError, ResponseOrderDto> findOrderById(Long id) {
        return repository.findById(id)
                .map(OrderEntity::toResponseOrderDto)
                .map((Function<ResponseOrderDto, Either<OrderResponseError, ResponseOrderDto>>)
                        Either::right)
                .orElseGet(() -> Either.left(new OrderResponseError("Order not found", LocalDateTime.now())));
    }

}
