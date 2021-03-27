package pl.equipment.store.application.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.port.out.CreateOrder;
import pl.equipment.store.domain.order.port.out.FindOrder;

import java.util.List;

@RestController
@RequiredArgsConstructor
class OrderController {
    private final CreateOrder createOrder;
    private final FindOrder findOrder;

    @PostMapping("/users/{userId}/orders")
    ResponseEntity<?> saveOrder(@PathVariable("userId") Long userId) {
        return createOrder.create(userId)
                .map(order -> ResponseEntity.ok((Object) order))
                .getOrElseGet(error -> ResponseEntity.badRequest().body(error));
    }

    @GetMapping("/orders")
    List<ResponseOrderDto> getAllOrders() {
        return findOrder.findAll();
    }

    @GetMapping("/orders/{id}")
    ResponseEntity<?> findOrderById(@PathVariable Long id) {
        return findOrder.findById(id)
                .map(order -> ResponseEntity.ok((Object) order))
                .getOrElseGet(error -> ResponseEntity.badRequest().body(error));
    }

}
