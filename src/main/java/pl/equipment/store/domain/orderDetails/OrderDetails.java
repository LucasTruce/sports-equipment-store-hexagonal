package pl.equipment.store.domain.orderDetails;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class OrderDetails {
    private final Long id;
    private final int quantity;
    private final Long orderId;
    private final Long productId;

    static OrderDetails create(int quantity, Long orderId, Long productId){
        return new OrderDetails(null, quantity, orderId, productId);
    }

}
