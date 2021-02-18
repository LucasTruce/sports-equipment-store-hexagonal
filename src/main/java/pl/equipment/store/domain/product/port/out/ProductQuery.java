package pl.equipment.store.domain.product.port.out;

import pl.equipment.store.domain.product.dto.ProductDto;

import java.util.List;

public interface ProductQuery {
    List<ProductDto> getProducts();
}
