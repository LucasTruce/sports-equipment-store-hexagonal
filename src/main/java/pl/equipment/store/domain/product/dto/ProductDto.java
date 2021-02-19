package pl.equipment.store.domain.product.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ProductDto {
    private final Long id;
    private final String name;
    private final String description;
    private final double unitPrice;
    private final int unitsInStock;
    private final String imageUrl;
    private final boolean active;

}
