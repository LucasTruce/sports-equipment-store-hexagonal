package pl.equipment.store.domain.product.port.out;

import pl.equipment.store.domain.product.port.shared.ProductDto;

public interface ProductRepository {
    ProductDto save(ProductDto productDto);
    ProductDto load(Long productId);
}
