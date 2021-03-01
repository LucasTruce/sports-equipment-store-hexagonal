package pl.equipment.store.application.orderDetails;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsError;
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
    ResponseEntity<?> createOrderDetails(@RequestBody CreateOrderDetailsRequest createOrderDetailsDto){
        Either<OrderDetailsError, OrderDetailsResponseDto> either = orderDetailsCommand.createOrderDetails(CreateOrderDetailsRequest.toCreateOrderDetailsDto(createOrderDetailsDto));
        if(either.isRight())
            return ResponseEntity.ok(either.get());
        return ResponseEntity.badRequest().body(either.getLeft());

    }

    @GetMapping
    List<OrderDetailsResponseDto> getAllOrderDetails(){
        return orderDetailsQuery.findAllOrderDetails();
    }
}
