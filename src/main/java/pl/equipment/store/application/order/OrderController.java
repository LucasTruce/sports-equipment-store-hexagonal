package pl.equipment.store.application.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.order.dto.CreateOrderDto;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
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
    ResponseOrderDto saveOrder(@RequestBody CreateOrderDto createOrderDto){
        return orderCommand.createOrder(createOrderDto);
    }

    @GetMapping
    List<ResponseOrderDto> getAllOrders(){
        return orderQuery.findAllOrders();
    }
}
