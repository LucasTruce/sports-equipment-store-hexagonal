package pl.equipment.store.infrastructure.product;

import pl.equipment.store.domain.orderDetails.dto.OrderDetailsProductDto;
import pl.equipment.store.domain.product.dto.ProductResponseDto;
import pl.equipment.store.domain.product.dto.SaveProductDto;

class ProductMapper {

    static ProductEntity toEntity(SaveProductDto saveProductDto) {
        return new ProductEntity(saveProductDto.getId(),
                saveProductDto.getName(),
                saveProductDto.getDescription(),
                saveProductDto.getUnitPrice(),
                saveProductDto.getUnitsInStock(),
                saveProductDto.isActive());
    }

    static ProductResponseDto toResponseDto(ProductEntity productEntity) {
        return new ProductResponseDto(productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getUnitPrice(),
                productEntity.getUnitsInStock());
    }

    static OrderDetailsProductDto toProductDto(ProductEntity productEntity) {
        return new OrderDetailsProductDto(productEntity.getUnitPrice(), productEntity.getUnitsInStock());
    }
}
