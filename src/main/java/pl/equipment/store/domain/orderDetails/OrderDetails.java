package pl.equipment.store.domain.orderDetails;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.dto.SaveOrderDetailsDto;

import java.math.BigDecimal;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class OrderDetails {
    private final Long id;
    private final int quantity;
    private final Long orderId;
    private final Long productId;

    static SaveOrderDetailsDto create(CreateOrderDetailsDto createOrderDetailsDto, BigDecimal totalPrice, int unitsInStock) {
        return new SaveOrderDetailsDto(
                null,
                createOrderDetailsDto.getQuantity(),
                createOrderDetailsDto.getOrderId(),
                createOrderDetailsDto.getProductId(),
                totalPrice,
                unitsInStock);
    }

}
