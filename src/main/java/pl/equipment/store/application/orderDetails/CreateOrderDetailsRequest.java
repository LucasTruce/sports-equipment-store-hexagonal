package pl.equipment.store.application.orderDetails;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;

@RequiredArgsConstructor
@Getter
class CreateOrderDetailsRequest {
    @NotNull
    private final int quantity;
    private final Long orderId;
    private final Long productId;

    static CreateOrderDetailsDto toCreateOrderDetailsDto(CreateOrderDetailsRequest orderDetailsRequest){
        return new CreateOrderDetailsDto(orderDetailsRequest.getQuantity(), orderDetailsRequest.getOrderId(), orderDetailsRequest.getProductId());
    }
}
