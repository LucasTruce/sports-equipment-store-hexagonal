package pl.equipment.store.domain.product;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.product.dto.CreateProductDto;
import pl.equipment.store.domain.product.dto.SaveProductDto;

import java.math.BigDecimal;

@RequiredArgsConstructor
class Product {
    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal unitPrice;
    private final int unitsInStock;
    private final String imageUrl;
    private final boolean active;

    static Product create(CreateProductDto productDto) {
        return new Product(
                null,
                productDto.getName(),
                productDto.getDescription(),
                productDto.getUnitPrice(),
                productDto.getUnitsInStock(),
                "",
                true);
    }

    SaveProductDto toSaveProductDto() {
        return new SaveProductDto(id, name, description, unitPrice, unitsInStock, imageUrl, active);
    }
}
