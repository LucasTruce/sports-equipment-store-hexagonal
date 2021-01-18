package pl.equipment.store.domain.product.port.in;

import pl.equipment.store.domain.product.port.shared.ProductDto;

import java.util.List;

public interface ProductPort {
    ProductDto createProduct(String name);
    List<ProductDto> getProducts();
}
