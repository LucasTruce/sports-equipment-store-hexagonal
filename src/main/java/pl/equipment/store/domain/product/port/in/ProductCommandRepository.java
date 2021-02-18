package pl.equipment.store.domain.product.port.in;

import pl.equipment.store.domain.product.dto.ProductDto;

public interface ProductCommandRepository {
    ProductDto save(ProductDto productDto);
}
