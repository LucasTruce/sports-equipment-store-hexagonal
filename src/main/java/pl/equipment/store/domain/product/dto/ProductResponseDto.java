package pl.equipment.store.domain.product.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class ProductResponseDto {
    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal unitPrice;
    private final int unitsInStock;
    private final String imageUrl;
    private final boolean active;

}
