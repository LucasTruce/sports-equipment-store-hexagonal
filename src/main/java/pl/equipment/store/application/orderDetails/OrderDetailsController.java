package pl.equipment.store.application.orderDetails;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseError;
import pl.equipment.store.domain.orderDetails.port.out.OrderDetailsCommand;
import pl.equipment.store.domain.orderDetails.port.out.OrderDetailsQuery;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("order-details")
class OrderDetailsController {
    private final OrderDetailsCommand orderDetailsCommand;
    private final OrderDetailsQuery orderDetailsQuery;

    @PostMapping
    ResponseEntity<?> createOrderDetails(@RequestBody @Valid CreateOrderDetailsRequest createOrderDetailsDto) {
        Either<OrderDetailsResponseError, OrderDetailsResponseDto> either = orderDetailsCommand.createOrderDetails(CreateOrderDetailsRequest.toCreateOrderDetailsDto(createOrderDetailsDto));
        if (either.isRight())
            return ResponseEntity.ok(either.get());
        return either
                .map(d -> ResponseEntity.ok( (Object)d ))
                .getOrElseGet( o -> ResponseEntity.badRequest().body(o));
    }

    @GetMapping
    List<OrderDetailsResponseDto> getAllOrderDetails() {
        return orderDetailsQuery.findAllOrderDetails();
    }
}
