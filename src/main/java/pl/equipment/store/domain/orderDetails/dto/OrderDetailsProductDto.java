package pl.equipment.store.domain.orderDetails.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class OrderDetailsProductDto {
    private final BigDecimal unitPrice;
    private final int unitsInStock;
}
