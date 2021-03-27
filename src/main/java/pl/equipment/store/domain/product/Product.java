package pl.equipment.store.domain.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.product.dto.CreateProductDto;
import pl.equipment.store.domain.product.dto.SaveProductDto;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
class Product {
    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal unitPrice;
    private final int unitsInStock;
    private final String imageUrl;
    private final boolean active;

    static SaveProductDto create(CreateProductDto productDto) {
        return new SaveProductDto(
                null,
                productDto.getName(),
                productDto.getDescription(),
                productDto.getUnitPrice(),
                productDto.getUnitsInStock(),
                "",
                true);
    }

}
