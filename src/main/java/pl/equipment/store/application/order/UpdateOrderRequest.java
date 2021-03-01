package pl.equipment.store.application.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.order.dto.UpdateOrderDto;

@RequiredArgsConstructor
@Getter
class UpdateOrderRequest {
    private final Long productId;
    private final int quantity;

    static UpdateOrderDto toUpdateOrderDto(UpdateOrderRequest updateOrderRequest){

        return new UpdateOrderDto(updateOrderRequest.getProductId(), updateOrderRequest.getQuantity());
    }
}
