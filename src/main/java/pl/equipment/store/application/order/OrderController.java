package pl.equipment.store.application.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    ResponseOrderDto saveOrder(@RequestBody @Valid CreateOrderRequest createOrderRequest){
        return orderCommand.createOrder(CreateOrderRequest.toCreateOrderDto(createOrderRequest));
    }

    @GetMapping
    List<ResponseOrderDto> getAllOrders(){
        return orderQuery.findAllOrders();
    }

    @PutMapping("/{id}")
    ResponseOrderDto updateOrderTotalPrice(@PathVariable Long id, @RequestBody UpdateOrderRequest updateOrderRequest){

        return orderCommand.updateOrder(orderQuery.findOrderById(id),
                UpdateOrderRequest.toUpdateOrderDto(updateOrderRequest));
    }
}
