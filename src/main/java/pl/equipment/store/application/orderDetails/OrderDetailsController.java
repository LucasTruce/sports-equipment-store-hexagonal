package pl.equipment.store.application.orderDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.port.out.CreateOrderDetails;
import pl.equipment.store.domain.orderDetails.port.out.FindOrderDetails;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("order-details")
class OrderDetailsController {
    private final CreateOrderDetails createOrderDetails;
    private final FindOrderDetails findOrderDetails;

    @PostMapping
    ResponseEntity<?> createOrderDetails(@RequestBody @Valid CreateOrderDetailsRequest createOrderDetailsRequest) {
        return createOrderDetails.create(CreateOrderDetailsRequest.toCreateOrderDetailsDto(createOrderDetailsRequest))
                .map(orderDetails -> ResponseEntity.ok((Object) orderDetails))
                .getOrElseGet(error -> ResponseEntity.badRequest().body(error));
    }

    @GetMapping
    List<OrderDetailsResponseDto> getAllOrderDetails() {
        return findOrderDetails.findAll();
    }
}
