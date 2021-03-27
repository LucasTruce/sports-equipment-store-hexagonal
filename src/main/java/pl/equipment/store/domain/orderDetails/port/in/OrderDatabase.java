package pl.equipment.store.domain.orderDetails.port.in;

import io.vavr.control.Option;

import java.math.BigDecimal;

public interface OrderDatabase {
    Option<BigDecimal> getTotalPrice(Long orderId);

    Option<Long> updateTotalPrice(Long id, BigDecimal totalPrice);
}
