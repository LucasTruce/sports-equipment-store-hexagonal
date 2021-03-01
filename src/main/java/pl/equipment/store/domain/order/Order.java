package pl.equipment.store.domain.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter
class Order {
    private Long id;
    private String status;
    private double totalPrice;
    private Long userId;

    static Order create(String status, Long userId){
        return new Order(null, status, 0, userId);
    }
}
