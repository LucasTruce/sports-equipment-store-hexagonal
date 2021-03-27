package pl.equipment.store.domain.orderDetails.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SaveOrderDetailsDto {
    private final Long id;
    private final int quantity;
    private final Long orderId;
    private final Long productId;
}
