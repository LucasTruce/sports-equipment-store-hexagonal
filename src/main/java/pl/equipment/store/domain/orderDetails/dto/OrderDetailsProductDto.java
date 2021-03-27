package pl.equipment.store.domain.orderDetails.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class OrderDetailsProductDto {
    private final BigDecimal unitPrice;
    private final int unitsInStock;

    public boolean isAvailable(int quantity) {
        return unitsInStock >= quantity;
    }

    public BigDecimal calculateTotalOrderPrice(int quantity) {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}
