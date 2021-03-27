package pl.equipment.store.domain.orderDetails;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.dto.SaveOrderDetailsDto;

@RequiredArgsConstructor
@Getter
class OrderDetails {
    private final Long id;
    private final int quantity;
    private final Long orderId;
    private final Long productId;

    static SaveOrderDetailsDto create(CreateOrderDetailsDto createOrderDetailsDto) {
        return new SaveOrderDetailsDto(
                null,
                createOrderDetailsDto.getQuantity(),
                createOrderDetailsDto.getOrderId(),
                createOrderDetailsDto.getProductId());
    }

}
