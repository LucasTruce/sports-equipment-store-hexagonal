package pl.equipment.store.domain.order;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.order.dto.OrderResponseError;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.port.out.CreateOrder;
import pl.equipment.store.domain.order.port.out.FindOrder;

import java.util.List;


@RequiredArgsConstructor
class OrderFacade implements CreateOrder, FindOrder {

    private final OrderService orderService;

    @Override
    public Either<OrderResponseError, ResponseOrderDto> create(Long userId) {
        return orderService.save(userId);
    }

    @Override
    public List<ResponseOrderDto> findAll() {
        return orderService.findAll();
    }

    @Override
    public Either<OrderResponseError, ResponseOrderDto> findById(Long id) {
        return orderService.findById(id);
    }
}
