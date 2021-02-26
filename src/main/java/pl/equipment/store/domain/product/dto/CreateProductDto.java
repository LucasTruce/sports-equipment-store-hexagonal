package pl.equipment.store.domain.product.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CreateProductDto {
    private final String name;
    private final String description;
    private final double unitPrice;
    private final int unitsInStock;
}
