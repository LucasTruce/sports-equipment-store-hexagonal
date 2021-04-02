package pl.equipment.store.domain.orderDetails;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.dto.SaveOrderDetailsDto;

@RequiredArgsConstructor
class OrderDetails {
    private final Long id;
    private final int quantity;
    private final Long orderId;
    private final Long productId;

    static OrderDetails create(CreateOrderDetailsDto createOrderDetailsDto) {
        return new OrderDetails(
                null,
                createOrderDetailsDto.getQuantity(),
                createOrderDetailsDto.getOrderId(),
                createOrderDetailsDto.getProductId());
    }

    SaveOrderDetailsDto toSaveOrderDetailsDto() {
        return new SaveOrderDetailsDto(id, quantity, orderId, productId);
    }

}
