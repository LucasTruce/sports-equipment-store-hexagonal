package pl.equipment.store.domain.product.port.out;

import pl.equipment.store.domain.product.dto.ProductResponseDto;

import java.util.List;

public interface ProductQuery {
    List<ProductResponseDto> findAllProducts();
}
