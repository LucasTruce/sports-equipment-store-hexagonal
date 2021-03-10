package pl.equipment.store.application.orderDetails;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Getter
class CreateOrderDetailsRequest {

    @NotNull
    @Min(1)
    private final int quantity;
    private final Long orderId;
    private final Long productId;

    static CreateOrderDetailsDto toCreateOrderDetailsDto(CreateOrderDetailsRequest orderDetailsRequest) {
        return new CreateOrderDetailsDto(orderDetailsRequest.getQuantity(), orderDetailsRequest.getOrderId(), orderDetailsRequest.getProductId());
    }
}
