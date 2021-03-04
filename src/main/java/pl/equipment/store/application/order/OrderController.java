package pl.equipment.store.application.order;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.order.dto.OrderResponseError;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.port.out.OrderCommand;
import pl.equipment.store.domain.order.port.out.OrderQuery;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
class OrderController {
    private final OrderCommand orderCommand;
    private final OrderQuery orderQuery;

    @PostMapping
    ResponseEntity<?> saveOrder(@RequestBody @Valid CreateOrderRequest createOrderRequest) {
        Either<OrderResponseError, ResponseOrderDto> either = orderCommand.createOrder(CreateOrderRequest.toCreateOrderDto(createOrderRequest));
        if (either.isLeft())
            return ResponseEntity.badRequest().body(either.getLeft());
        return ResponseEntity.ok(either.get());
    }

    @GetMapping
    List<ResponseOrderDto> getAllOrders() {
        return orderQuery.findAllOrders();
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findOrderById(@PathVariable Long id) {
        Either<OrderResponseError, ResponseOrderDto> either = orderQuery.findOrderById(id);
        if (either.isLeft())
            return ResponseEntity.badRequest().body(either.getLeft());
        return ResponseEntity.ok(either.get());
    }

}
