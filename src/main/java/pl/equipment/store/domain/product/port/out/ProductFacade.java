package pl.equipment.store.domain.product.port.out;

import pl.equipment.store.domain.product.port.shared.ProductDto;

import java.util.List;

public interface ProductFacade {
    ProductDto createProduct(String name);
    List<ProductDto> getProducts();
}
