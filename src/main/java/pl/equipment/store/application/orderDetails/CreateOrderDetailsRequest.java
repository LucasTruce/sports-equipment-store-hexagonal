package pl.equipment.store.application.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
class CreateOrderDetailsRequest {
    @NotNull
    @Min(1)
    private int quantity;
    private Long orderId;
    private Long productId;

    static CreateOrderDetailsDto toCreateOrderDetailsDto(CreateOrderDetailsRequest orderDetailsRequest) {
        return new CreateOrderDetailsDto(orderDetailsRequest.getQuantity(),
                orderDetailsRequest.getOrderId(),
                orderDetailsRequest.getProductId());
    }
}
