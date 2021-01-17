package pl.equipment.store.domain.product.port.in;

import pl.equipment.store.domain.product.port.shared.ProductDto;

public interface ProductService {
    ProductDto createProduct(String name);
}
