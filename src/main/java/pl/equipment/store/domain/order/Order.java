package pl.equipment.store.domain.order;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class Order {
    private final Long id;
    private final String status;
    private final LocalDateTime date;

    static Order create(String status){
        return new Order(null, status, LocalDateTime.now());
    }
}
