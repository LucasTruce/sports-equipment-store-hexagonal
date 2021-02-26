package pl.equipment.store.domain.product.port.in;

import pl.equipment.store.domain.product.dto.ProductResponseDto;

import java.util.List;

public interface ProductQueryRepository {
    List<ProductResponseDto> findProducts();
}
