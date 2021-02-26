package pl.equipment.store.domain.order;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class Order {
    private final Long id;
    private final String status;
    private final double totalPrice;
    private final Long userId;

    static Order create(String status, Long userId){
        return new Order(null, status, 0, userId);
    }
}
