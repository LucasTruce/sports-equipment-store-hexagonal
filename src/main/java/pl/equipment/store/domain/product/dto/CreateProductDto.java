package pl.equipment.store.domain.product.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class CreateProductDto {
    private final String name;
    private final String description;
    private final BigDecimal unitPrice;
    private final int unitsInStock;
}
