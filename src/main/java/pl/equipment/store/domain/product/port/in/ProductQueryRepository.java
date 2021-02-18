package pl.equipment.store.domain.product.port.in;

import pl.equipment.store.domain.product.dto.ProductDto;

import java.util.List;

public interface ProductQueryRepository {
    List<ProductDto> findProducts();
}
