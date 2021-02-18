package pl.equipment.store.application.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.order.dto.OrderDto;
import pl.equipment.store.domain.order.port.out.OrderCommand;
import pl.equipment.store.domain.order.port.out.OrderQuery;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
class OrderController {
    private final OrderCommand orderCommand;
    private final OrderQuery orderQuery;

    @PostMapping
    OrderDto saveOrder(@RequestBody OrderDto orderDto){
        return orderCommand.createOrder(orderDto.getStatus());
    }

    @GetMapping
    List<OrderDto> getAllOrders(){
        return orderQuery.findAllOrders();
    }
}
