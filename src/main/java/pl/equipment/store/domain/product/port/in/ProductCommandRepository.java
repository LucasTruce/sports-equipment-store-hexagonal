package pl.equipment.store.domain.product.port.in;

import pl.equipment.store.domain.product.dto.ProductResponseDto;

public interface ProductCommandRepository {
    ProductResponseDto save(ProductResponseDto productResponseDto);
}
