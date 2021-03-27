package pl.equipment.store.domain.order;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.order.dto.OrderResponseError;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.port.in.OrderRepository;
import pl.equipment.store.domain.order.port.in.UserDatabase;

import java.util.List;

@RequiredArgsConstructor
class OrderService {

    private final OrderRepository orderRepository;
    private final UserDatabase userDatabase;

    public Either<OrderResponseError, ResponseOrderDto> save(Long userId) {
        if (userDatabase.existsById(userId))
            return Either.right(orderRepository.save(Order.create(userId)));
        return Either.left(new OrderResponseError("User not found!"));
    }

    public List<ResponseOrderDto> findAll() {
        return orderRepository.findAll();
    }

    public Either<OrderResponseError, ResponseOrderDto> findById(Long id) {
        return orderRepository.findById(id)
                .toEither(new OrderResponseError("Order not found!"));
    }
}
