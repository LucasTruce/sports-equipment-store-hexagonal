package pl.equipment.store.application.orderDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.port.out.OrderDetailsCommand;
import pl.equipment.store.domain.orderDetails.port.out.OrderDetailsQuery;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("order-details")
class OrderDetailsController {
    private final OrderDetailsCommand orderDetailsCommand;
    private final OrderDetailsQuery orderDetailsQuery;

    @PostMapping
    OrderDetailsResponseDto createOrderDetails(@RequestBody CreateOrderDetailsRequest createOrderDetailsDto){
        return orderDetailsCommand.createOrderDetails(CreateOrderDetailsRequest.toCreateOrderDetailsDto(createOrderDetailsDto));
    }

    @GetMapping
    List<OrderDetailsResponseDto> getAllOrderDetails(){
        return orderDetailsQuery.findAllOrderDetails();
    }
}
