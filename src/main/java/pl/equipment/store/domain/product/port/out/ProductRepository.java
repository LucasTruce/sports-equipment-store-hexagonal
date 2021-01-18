package pl.equipment.store.domain.product.port.out;

import pl.equipment.store.domain.product.port.shared.ProductDto;

import java.util.List;

public interface ProductRepository {
    ProductDto save(ProductDto productDto);
    List<ProductDto> findProducts();
}
